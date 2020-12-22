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
	
	var option = {
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data:${ x1 }
    },
    series: [
        {
            name:'工作类型',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:${ y1 }
        }
    ]
};
	 // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
	</script>
</body>
</html>