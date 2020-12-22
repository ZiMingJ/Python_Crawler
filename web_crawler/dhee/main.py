# -*- coding: utf-8 -*-
import scrapy.cmdline


def main():
    scrapy.cmdline.execute(argv=['scrapy', 'crawl', 'dheespider'])


if __name__ == '__main__':
    main()
