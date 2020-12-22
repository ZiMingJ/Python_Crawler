# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html


class Meiju100Pipeline(object):
    def process_item(self, item, spider): #每执行一次yield item就自动调用
        self.f.write(item['title'] + '\n')
        return item

    def open_spider(self,spider):
        self.f = open('F:/data.txt','w')

    def close_spider(self,spider):
        self.f.close()

#news(id,title)
import pymysql

class DBPipeline(object):

    def process_item(self, item, spider): #每执行一次yield item就自动调用
        with self.conn.cursor() as cursor:
            cursor.execute(self.sql, (item['title']))
        return item

    def open_spider(self,spider):
        config = {'host': 'localhost', 'user': 'root', 'password': '123456', 'database': 'DB'}
        self.conn = pymysql.connect(**config)
        self.sql = 'insert into news(title) values(%s)'
    
    def close_spider(self,spider):
        self.conn.close()