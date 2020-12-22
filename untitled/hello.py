# a = int(input("a:"))
# b = int(input("b:"))
# c = int(input("c:"))
# if a > b:
#     a,b = b,a
# if b > c:
#     b,c = c,b
# if a > b:
#     a,b = b,a
# print(a,b,c)

# y m d

# import random
# n = random.randint(1,10)
# while True:
#     m = int(input("qing shu ru"))
#     if n==m:
#         print("right")
#         break
#     elif n>m:
#         print("smaller")
#     elif n<m:
#         print("bigger")

# sum = 0
# for i in range(1,101):
#     sum = sum + i
# print(sum)

# a = int(input("a:"))
# b = int(input("b:"))
# min = min(a,b)
# result = 0
# for i in range(1,min+1):
#     if a % i == 0 and b % i ==0:
#         result = i
# print(result)


# for i in range(100,1000):
#     a = i // 100
#     b = i // 10 % 10
#     c = i % 10
#     if (a**3 + b**3 + c**3 == i):
#         print(i)

# import random
# list  = [1,2,3,4,5,6,7,8,9,10]
# result = []
#
# for i in range(5):
#     idx = random.randint(0,len(list) - 1)#取值两边
#     result.append(list[idx])
#     list.remove(list[idx])
# print(result)

#lstrip rstrip

#dict = {'key':1,...}

# #单位变换
# a = int(input("a:"))
# def transfer(a) :
#     if a < 1024:
#         print(str(a) , "bit")
#     count = 0
#     s, y = divmod(a, 1024)
#     while y >= 1024:
#         r = s + y
#         count += 1
#         if count == 1:
#             print(str(r) , "K")
#         if count == 2:
#             print(str(r) , "M")
#         if count == 3:
#             print(str(r) ,"G")
#         s, y = divmod(a, 1024)
# transfer(a)

# b = int(input("b:"))
# x = ['b','k','m','g']
# idx = 0
# while b // 1024:
#     idx += 1
#     b = b // 1024
# print(str(b) + x[idx])

# b = int(input("b:"))
# x = ['b','k','m','g']
# idx = 0
# def calc(b):
#     global idx
#     if b // 1024:
#         idx += 1
#         return calc(b // 1024)
#     else:
#         return b
# print(str(calc(b)) + x[idx])

# * tuple
# ** dict

# f = open("C:/test.txt","r")
# f2 = open("C:/test1.txt","w")
# i=0
# for line in f:
#     i += 1
#     print(line,end="")
#     line = str(i) +" "+ line
#     f2.write(line)
# f.close()
# f2.close()

# import pymysql
# config = {'host':'localhost','user':'root','password':'123456','database':'python'}
# conn = pymysql.connect(**config)
# print(conn)
# cursor = conn.cursor()
# sql = 'insert into student(name) values(%s)'
# row = cursor.execute(sql,('zhang'))
# print(row)

# sql = 'delete from student where name = %s'
# row = cursor.execute(sql,('zhang'))
# print(row)
#
# sql = 'select * from student'
# cursor.execute(sql)
# rows = cursor.fetchall()
# for row in rows:
#     print(row[0],row[1]) #Tuple
# conn.commit()
# conn.close()

import urllib.request
from bs4 import BeautifulSoup
response = urllib.request.urlopen('http://115.29.32.68/EVSelectNews.do?newsType=1')

soup = BeautifulSoup(response.read().decode("utf-8"),'html.parser')
# print(soup.title.string)
# print(soup.p.string)
# print(soup.find_all('p'))
# print(soup.select('title'))
# print(soup.select('p'))
news = soup.select('.tit.f-toe')
f = open("C:\dhee.txt","w")
for n in news:
    f.write(n.string.strip()+'\n')
f.close()

# import urllib.request
# from bs4 import BeautifulSoup
# response = urllib.request.urlopen('https://www.meijutt.com/new100.html')
#
# soup = BeautifulSoup(response.read().decode("gb2312"),'html.parser')
# # print(soup.title.string)
# # print(soup.p.string)
# # print(soup.find_all('p'))
# # print(soup.select('title'))
# # print(soup.select('p'))
# news = soup.select('li>h5>a')
# f = open("C:\meiju.txt","w",encoding='utf-8')
# i = 0
# for n in news:
#     # soup.select('{0}'.format())
#     i+=1
#     f.write(str(i)+n.string.strip()+'\n')
# f.close()

# -*- coding: utf-8 -*-
import scrapy


class MeijuSpider(scrapy.Spider):
    name = 'dhee'
    allowed_domains = ['115.29.32.68']
    start_urls = ['http://115.29.32.68/EVSelectNews.do?newsType=1']

    def parse(self, response):
    #extract()转换为unicode

        a = response.xpath('//p[@class="tit f-toe"]/text()').extract()
        for title in a :
            print(title.strip())