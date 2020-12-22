# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

import pymysql

class BossPipeline(object):

    def process_item(self, item, spider):  # 每执行一次yield item就自动调用
        with self.conn.cursor() as cursor:
            cursor.execute(self.sql, (item['job'],item['salary'],item['company']))
            self.conn.commit()
        return item

    def open_spider(self, spider):
        config = {'host': 'localhost', 'user': 'root', 'password': '123456', 'database': 'boss'}
        self.conn = pymysql.connect(**config)
        self.sql = 'insert into info(job,salary,company) values(%s,%s,%s)'

    def close_spider(self, spider):
        self.conn.close()