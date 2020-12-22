# -*- coding: utf-8 -*-
import scrapy
import re
from boss.items import BossItem

class BossspiderSpider(scrapy.Spider):
    name = 'bossspider'
    allowed_domains = ['zhipin.com']
    start_urls = ['https://www.zhipin.com/c100010000-p100109/?ka=sel-city-100010000']

    def __init__(self):
        self.page = 1
    #     # 第一次访问
    # def start_requests(self):
    #     for url in self.start_urls:
    #         yield scrapy.Request(url, callback=self.parse, meta={'proxy': 'http://183.245.98.6:8118'})  # 函数指针
    def parse(self, response):
        item = BossItem()
        node_list = response.xpath('//div[@class="job-list"]/ul/li')
        for node in node_list:
            item['job'] = node.xpath('.//div[@class="info-primary"]//div[@class="job-title"]/text()').extract()
            salary = node.xpath('.//span[@class="red"]/text()')[0].extract()
            if len(salary) > 6:
                salary = salary[0:6]

            a,b = re.split("-", salary)
            b1 = b.replace("K","")
            c = []
            c.append(str((int(a) + int(b1))/2))
            item['salary'] = c
            item['company'] = node.xpath('.//div[@class="job-primary"]/div[@class="info-company"]//a/text()').extract()
            print(item['job'],item['salary'],item['company'])
            yield item  # 吧item对象传递到下一个pipeline
        #爬取下一页
        self.page += 1
        if response.xpath('//div[@class="page"]/a[@href="/c100010000-p100109/?page={0}"]'.format(self.page)).extract_first() is not None and self.page<=2:
            nextpage = 'https://www.zhipin.com/c100010000-p100109/?page={0}'.format(self.page)
            yield scrapy.Request(nextpage, callback=self.parse)  # 函数指针
        #     # , meta = {'proxy': 'http://183.245.98.6:8118'}

        # # 定义下页标签的元素位置
        # next_page = response.xpath('//div[@class="page"]/a[@href="/c100010000-p100109/?page={0}"]'.format(self.page)).extract()[-1]
        # # 判断什么时候下页没有任何数据
        # if next_page != 'javascript:;':
        #     base_url = "https://www.zhipin.com"
        #     url = base_url + next_page
        #     yield scrapy.Request(url=url, callback=self.parse)
