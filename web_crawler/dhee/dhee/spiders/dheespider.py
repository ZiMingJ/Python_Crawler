# -*- coding: utf-8 -*-
import scrapy

from dhee.items import DheeItem
class DheespiderSpider(scrapy.Spider):
    name = 'dheespider'
    allowed_domains = ['115.29.32.68']
    start_urls = ['http://115.29.32.68/EVSelectNews.do?newsType=1']

    def __init__(self):
        self.page = 1

    #第一次访问
    def start_requests(self):
        for url in self.start_urls:
            yield scrapy.Request(url, callback=self.parse, meta={'proxy': 'http://202.112.237.102:3128'})  # 函数指针

    def parse(self, response):
        titles = response.xpath('//p[@class="tit f-toe"]/text()').extract()
        # for title in titles:
        #     print(title.strip())
        for title in titles:
            print(title.strip())
            item = DheeItem()
            item['title'] = title.strip()
            yield item #吧item对象传递到下一个pipeline

        #爬取下一页
        self.page += 1
        if response.xpath('//a[@href="/EVSelectNews.do?nowPage={0}"]'.format(self.page)).extract_first() is not None:
            nextpage = 'http://115.29.32.68/EVSelectNews.do?nowPage={0}'.format(self.page)
            yield scrapy.Request(nextpage, callback=self.parse, meta={'proxy':'http://218.60.8.83:3129'}) #函数指针

#scrapy startproject dhee
#cd dhee
#scrapy genspider dheespider dhee.com.cn