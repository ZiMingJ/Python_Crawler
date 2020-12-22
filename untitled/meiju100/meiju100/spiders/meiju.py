# -*- coding: utf-8 -*-

import scrapy
from meiju100.meiju100.items import Meiju100Item
class MeijuSpider(scrapy.Spider):
    name = 'meiju'
    allowed_domains = ['meijutt.com']
    start_urls = ['https://www.meijutt.com/new100.html']

    def parse(self, response):
        #extract()转换为unicode
        titles = response.xpath('//ul[@class="top-list  fn-clear"]//h5/a/text()').extract()
        for title in titles:
            item = Meiju100Item()
            item['title'] = title.strip()
            print(title.strip())
            yield item #吧item对象传递到下一个pipeline