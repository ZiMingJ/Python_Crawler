<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="echarts.min.js"></script>
</head>
<body>
	<div id="main" style="width: 1000px; height: 400px;"></div>

	<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '公司招聘岗位数量分析'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ${ x }
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',//line、pie
                data: ${ y }
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

	<div id="main" style="width: 1000px; height: 400px;"></div>

	<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'python工作各公司薪资分析'
            },
            tooltip: {},
            legend: {
                data:['单位-/k']
            },
            xAxis: {
                data: ${ x2 }
            },
            yAxis: {},
            series: [{
                name: '单位-/k',
                type: 'bar',//line、pie
                data: ${ y2 }
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>