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