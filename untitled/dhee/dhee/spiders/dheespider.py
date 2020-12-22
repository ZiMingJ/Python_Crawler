# -*- coding: utf-8 -*-
import scrapy


class DheespiderSpider(scrapy.Spider):
    name = 'dheespider'
    allowed_domains = ['115.29.32.68']
    start_urls = ['http://115.29.32.68/EVSelectNews.do?newsType=1']

    def parse(self, response):
        a = response.xpath('//p[@class="tit f-toe"]/text()').extract()
        for title in a:
            print(title.strip())
