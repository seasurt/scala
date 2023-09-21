// alert("aaaa");

//1、Age的数据
var xdata1 = new Array();
var ydata1 = [];

//2、north_america的数据
var xdata2 = new Array();
var ydata2 = [];

//3、europe的数据
var xdata3 = new Array();
var ydata3 = [];

//4、asia的数据
var xdata4 = new Array();
var ydata4 = [];

//5、africa的数据
var xdata5 = new Array();
var ydata5 = [];

//6、oceania的数据
var xdata6 = new Array();
var ydata6 = [];

//7、south_america的数据
var xdata7 = new Array();
var ydata7 = [];

//8、airport的数据
var xdata8 = new Array();
var ydata8 = [];

//9、getcount的数据
var xdata9 = new Array();
var ydata9 = [];

//10、airline的数据
var xdata10 = new Array();
var ydata10 = [];
// var zdata10 = new Array();
// var vdata10 = [];


$(function () {

    //1
    $.ajax({
        type: "post",
        url: "/requirement/getAge",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata1.push(res[i].age);
                ydata1.push(res[i].count);
            }
            // console.log(xdata1);
            // console.log(ydata1);
            echarts_4();
        }
    });
    //2
    $.ajax({
        type: "post",
        url: "/requirement/getNorth_america",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata2.push(res[i].status);
                ydata2.push(res[i].count);
            }
            // console.log(xdata2);
            // console.log(ydata2);
            echarts_2();
        }
    });
    //3
    $.ajax({
        type: "post",
        url: "/requirement/getEurope",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata3.push(res[i].status);
                ydata3.push(res[i].count);
            }
            // console.log(ydata3);
            // console.log(ydata3);
            echarts_2();
        }
    });
    //4
    $.ajax({
        type: "post",
        url: "/requirement/getAsia",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata4.push(res[i].status);
                ydata4.push(res[i].count);
            }
            // console.log(xdata4);
            // console.log(ydata4);
            echarts_2();
        }
    });
    //5
    $.ajax({
        type: "post",
        url: "/requirement/getAfrica",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata5.push(res[i].status);
                ydata5.push(res[i].count);
            }
            // console.log(xdata5);
            // console.log(ydata5);
            echarts_2();
        }
    });
    //6
    $.ajax({
        type: "post",
        url: "/requirement/getOceania",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata6.push(res[i].status);
                ydata6.push(res[i].count);
            }
            // console.log(xdata6);
            // console.log(ydata6);
            echarts_2();
        }
    });
    //7
    $.ajax({
        type: "post",
        url: "/requirement/getSouth_america",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata7.push(res[i].status);
                ydata7.push(res[i].count);
            }
            // console.log(xdata7);
            // console.log(ydata7);
            echarts_2();
        }
    });
    //8
    $.ajax({
        type: "post",
        url: "/requirement/getAirport",
        data: null,

        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata8.push(res[i].Airport_name);
                ydata8.push(res[i].count);
            }
            console.log(xdata8);
            console.log(ydata8);
            echarts_5();
        }
    });

    //9
    //echarts_1();
    $.ajax({
        type: "post",
        url: "/requirement/getGetcounts",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                xdata9.push(res[i].continents);
                ydata9.push(res[i].num);
            }
            // console.log(xdata9);
            // console.log(ydata9);
            //echarts_1();
            world1();
        }
    });

    //10
    // echarts_5();
    $.ajax({
        type: "post",
        url: "/requirement/getGetAirline",
        data: null,
        success: function (res) {
            // console.log(res);
            // console.log(res[0].province);
            // console.log(res[0].count);
            for (var i = 0; i < res.length; i++) {
                // xdata10.push(res[i].airport);
                // ydata10.push(res[i].country);
                // zdata10.push(res[i].month);
                // vdata10.push(res[i].num);
                xdata10.push(res[i].country);
                ydata10.push(res[i].num);

            }
             console.log(xdata10);
             console.log(ydata10);
            // console.log(zdata10);
            // console.log(vdata10);
             //world1();
            echarts_1();
        }
    });


    //各大洲航空客运量//中间   地球   大图
    function world1() {
        let myChart = echarts.init(document.getElementById('worldmap'));
        // 地球数据显示
        let ds = [

            {
                name:xdata9[1],
                point: [87, 43, 0],
                labelText :"亚洲"+" , "+ ydata9[1],
                itemStyleColor: '#f00'},

            {   name: xdata9[3],
                point: [25, 54, 0],
                labelText :"欧洲"+" , "+ydata9[3],
                itemStyleColor: '#eeff00'},

            { name: xdata9[4],
                point: [16, 2, 0],
                labelText :"非洲"+" , "+ ydata9[4],
                itemStyleColor: '#002aff'},

            { name: xdata9[0],
                point: [-100, 48, 0],
                labelText :"北美洲"+" , "+ ydata9[0],
                itemStyleColor: '#00fff7'},

            {name: xdata9[5],
                point: [-55, -15,0],
                labelText :"南美洲"+" , "+ ydata9[5],
                itemStyleColor: '#a100ff'},

            {name: xdata9[2],
                point: [135, -25, 0],
                labelText :"大洋洲"+" , "+ ydata9[2],
                itemStyleColor: '#48ff00'},






            // {
            //     name:'亚洲',
            //     point: [87, 43, 0],
            //     labelText :"亚洲"+" , "+vdata10[0],
            //     itemStyleColor: '#f00'},
            //
            // {   name: '欧洲',
            //     point: [25, 54, 0],
            //     labelText :"欧洲"+" , "+vdata10[1],
            //     itemStyleColor: '#eeff00'},
            //
            // { name: '非洲',
            //     point: [16, 2, 0],
            //     labelText :"非洲"+" , "+vdata10[2],
            //     itemStyleColor: '#002aff'},
            //
            //  { name: '北美',
            //     point: [-100, 48, 0],
            //     labelText :"北美洲"+" , "+vdata10[3],
            //     itemStyleColor: '#00fff7'},
            //
            // {name: '南美',
            //     point: [-55, -15,0],
            //     labelText :"南美洲"+" , "+vdata10[4],
            //     itemStyleColor: '#a100ff'},
            //
            // {name: '大洋洲',
            //     point: [135, -25, 0],
            //     labelText :"大洋洲"+" , "+vdata10[5],
            //     itemStyleColor: '#48ff00'},

        ]

        // let ds = [
        //
        //
        //     {
        //         name:'亚洲',
        //         point: [90, 45, 0],
        //         labelText :"亚洲"+" , "+vdata10[0],
        //         itemStyleColor: '#f00'},
        //
        // ]

        // 点配置信息
        let series = ds.map(item => {
            return {
                name: item.name, // 是否显示左上角图例
                type: 'scatter3D',
                coordinateSystem: 'globe',
                blendMode: 'lighter',
                symbolSize: 16, // 点位大小

                itemStyle: {
                    color: item.itemStyleColor, // 各个点位的颜色设置
                    opacity: 1, // 透明度
                    borderWidth: 0, // 边框宽度
                    // borderColor: 'rgba(255,255,255,0.8)' //rgba(180, 31, 107, 0.8)
                },
                label: {
                    show: true, // 是否显示字体
                    position: 'left', // 字体位置。top、left、right、bottom
                    formatter: item.labelText, // 具体显示的值
                    textStyle: {
                        color: '#fff', // 字体颜色
                        borderWidth: 0, // 字体边框宽度
                        borderColor: '#fff', // 字体边框颜色
                        fontFamily: 'sans-serif', // 字体格式
                        fontSize: 18, // 字体大小
                        fontWeight: 700 // 字体加粗
                    }
                },
                data: [item.point] // 数据来源
            }
        })

        // 添加上面的配置项到地球上
        myChart.setOption({
            // 图例设置
            legend: {
                selectedMode: 'multiple',
                x: 'right',
                y: 'bottom',
                data: ds.map(item => {
                    return item.name // 数据来源
                }),
                padding: [0, 0, 140, 500], // 填充位置,上、右、下、左
                orient: 'vertical', // 排列方式，vertical:垂直排列
                textStyle: {
                    color: '#fff', // 文字颜色
                }
            },
            // 地球背景色
            // backgroundColor: '#fff',

            // 地球参数设置
            globe: {
                baseTexture: '../images/e1.png', // 地球表面覆盖的图片,可以替换成自己想要的图片
                shading: 'color', // 地球中三维图形的着色效果
                viewControl: {
                    autoRotate: true, // 是否开启视角绕物体的自动旋转查看
                    autoRotateSpeed: 3, //物体自转的速度,单位为角度 / 秒，默认为10 ，也就是36秒转一圈。
                    autoRotateAfterStill: 2, // 在鼠标静止操作后恢复自动旋转的时间间隔,默认 3s
                    rotateSensitivity: 2, // 旋转操作的灵敏度，值越大越灵敏.设置为0后无法旋转。[1, 0]只能横向旋转.[0, 1]只能纵向旋转
                    targetCoord: [116.46, 39.92], // 定位到北京
                    maxDistance: 200,
                    minDistance: 200
                }
            },
            // 地球文字显示信息配置
            series: series
        })
    }






//各大洲机场数量比例//左上
    function echarts_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart1'));


        option = {
            tooltip: {
                trigger: 'item',

            },
            legend: {
                top: 'bottom',
                textStyle:{color:"#fff" }


            },
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            series: [
                {
                    name: 'Nightingale Chart',
                    type: 'pie',
                    radius: [20,100],
                    center: ['50%', '50%'],
                    roseType: 'area',
                    itemStyle: {
                        borderRadius: 6
                    },

                    data: [
                        // {
                        //     textStyle:{color:'#0ef35f'
                        // }
                        // },

                        // { value: ydata9[0], name: xdata9[0]},
                        // { value: ydata9[1], name: xdata9[1]},
                        // { value: ydata9[2], name: xdata9[2]},
                        // { value: ydata9[3], name: xdata9[3]},
                        // { value: ydata9[4], name: xdata9[4]},
                        // { value: ydata9[5], name: xdata9[5]},


                        { value: ydata10[0], name: xdata10[0]},
                        { value: ydata10[1], name: xdata10[1]},
                        { value: ydata10[2], name: xdata10[2]},
                        { value: ydata10[3], name: xdata10[3]},
                        { value: ydata10[4], name: xdata10[4]},
                        { value: ydata10[5], name: xdata10[5]},
                    ]
                }
            ]
        };


        // option = {
        //     //  backgroundColor: '#00265f',
        //     tooltip: {
        //         trigger: 'axis',
        //         axisPointer: {
        //             type: 'shadow'
        //         }
        //     },
        //     grid: {
        //         left: '0%',
        //         top: '10px',
        //         right: '0%',
        //         bottom: '4%',
        //         containLabel: true
        //     },
        //     xAxis: [{
        //         type: 'category',
        //         // data: ['商超门店', '教育培训', '房地产', '生活服务', '汽车销售', '旅游酒店', '五金建材'],
        //         data: xdata,
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLabel: {
        //             interval: 0,
        //             // rotate:50,
        //             show: true,
        //             splitNumber: 15,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //     }],
        //     yAxis: [{
        //         type: 'value',
        //         axisLabel: {
        //             //formatter: '{value} %'
        //             show: true,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1	)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //         splitLine: {
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //             }
        //         }
        //     }],
        //     series: [
        //         {
        //             type: 'bar',
        //             // data: [200, 300, 300, 900, 1500, 1200, 600],
        //             data: ydata,
        //             barWidth: '35%', //柱子宽度
        //             // barGap: 1, //柱子之间间距
        //             itemStyle: {
        //                 normal: {
        //                     color: '#2f89cf',
        //                     opacity: 1,
        //                     barBorderRadius: 5,
        //                 }
        //             }
        //         }
        //
        //     ]
        // };
        //
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }



    //各大洲航班延误率 //左下
    function echarts_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart2'));
        option = {
            legend: {
                textStyle:{color:"#fff" }
            },
            tooltip: {},
            // xAxis:{
            //     axisLabel:{
            //         color: "#ffffff"
            //         // textStyle: {
            //         //     color: "#ffffff"
            //         // }
            //     }
            // },
            // yAxis:{
            //     axisLabel:{
            //         color: "#ffffff"
            //         // textStyle: {
            //         //     color: "#ffffff"
            //         // }
            //     }
            // },
            dataset: {
                source: [
                    ['product', 'Cancelled', 'Delayed', 'On Time'],
                    ['NAM', ydata2[0], ydata2[1], ydata2[2]],
                    ['EU',  ydata3[0], ydata3[1], ydata3[2]],
                    ['AS',  ydata4[0], ydata4[1], ydata4[2]],
                    ['AF',  ydata5[0], ydata5[1], ydata5[2]],
                    ['OC',  ydata6[0], ydata6[1], ydata6[2]],
                    ['SAM', ydata7[0], ydata7[1], ydata7[2]]
                ]
            },
            xAxis: { type: 'category' },
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
        };
        // option = {
        //     //  backgroundColor: '#00265f',
        //     tooltip: {
        //         trigger: 'axis',
        //         axisPointer: {type: 'shadow'}
        //     },
        //     grid: {
        //         left: '0%',
        //         top: '10px',
        //         right: '0%',
        //         bottom: '4%',
        //         containLabel: true
        //     },
        //     xAxis: [{
        //         type: 'category',
        //         data: ['North America', 'Europe', 'Asia', 'Africa', 'Oceania','South America'],
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLabel: {
        //             interval: 0,
        //             // rotate:50,
        //             show: true,
        //             splitNumber: 15,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //     }],
        //     yAxis: [{
        //         type: 'value',
        //         axisLabel: {
        //             //formatter: '{value} %'
        //             show: true,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1	)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //         splitLine: {
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //             }
        //         }
        //     }],
        //     series: [
        //         {
        //
        //             type: 'bar',
        //             data: [ydata2,ydata3,ydata4],
        //             barWidth: '35%', //柱子宽度
        //             // barGap: 1, //柱子之间间距
        //             itemStyle: {
        //                 normal: {
        //                     color: '#27d08a',
        //                     opacity: 1,
        //                     barBorderRadius: 5,
        //                 }
        //             }
        //         }
        //
        //     ]
        // };
        //
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }



    //客运量前5的机场  // 右下
    function echarts_5() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart5'));


        option = {
            tooltip: {
                trigger: 'item',
                formatter:function (params){
                    params.name + ':' +params.value;
                }
            },
            toolbox: {
                feature: {
                    dataView: {
                        readOnly: false
                    },
                    restore: {},
                    saveAsImage: {}
                }
            },
            legend: {
                // data: ['首页', '产品页', '产品详情页', '下单页', '订单页']
                //data: [xdata8[4],xdata8[3],xdata8[2],xdata8[1],xdata8[0]
                data: ['San Fernando Airport',
                    'Santa Ana Airport',
                    'BÃ¶blingen Flugfeld',
                    'Santa Maria Airport',
                    'San Pedro Airport']
                ,
                textStyle:{color:"#fff" }
            },
            calculable: true,
            series: [{
                name: 'Funnel',
                type: 'funnel',
                left: '5%',
                top: 80,
                bottom: 20,
                width: '80%',
                min: 0,
                max: 100,
                minSize: '0%',
                maxSize: '100%',
                sort: 'descending',
                gap: 2,
                label: {
                    formatter: '{b} {c}%',
                    fontSize:12
                },
                labelLine: {
                    length: 10,
                    lineStyle: {
                        width: 1,
                        type: 'solid'
                    }
                },
                itemStyle: {
                    borderColor: '#fff',
                    borderWidth: 1
                },
                emphasis: {
                    label: {
                        fontSize: 13
                    }
                },
                data: [
                    // {value: 90, name: '首页'},
                    // {value: 70, name: '产品页'},
                    // {value: 50, name: '产品详情页'},
                    // {value: 10, name: '下单页'},
                    // {value: 5, name: '订单页'
                    { value: ydata8[4], name: 'San Fernando Airport' },
                    { value: ydata8[3], name: 'Santa Ana Airport' },
                    { value: ydata8[2], name: 'BÃ¶blingen Flugfeld' },
                    { value: ydata8[1], name: 'Santa Maria Airport' },
                    { value: ydata8[0], name: 'San Pedro Airport' }
                ]
            }]
        };



        // option = {
        //     // title: {
        //     //     text: 'Funnel'
        //     // },
        //     tooltip: {
        //         trigger: 'item',
        //
        //         //formatter: '{a} <br/>{b} : {c}%'
        //     },
        //     toolbox: {
        //         feature: {
        //             dataView: { readOnly: false },
        //             restore: {},
        //             saveAsImage: {}
        //         }
        //     },
        //     legend: {
        //         //data: ['Show', 'Click', 'Visit', 'Inquiry', 'Order'],
        //         data: [xdata8[4],xdata8[3],xdata8[2],xdata8[1],xdata8[0]],
        //     },
        //     series: [
        //         {
        //              name: 'Funnel',
        //             type: 'funnel',
        //             left: '10%',
        //             top: 60,
        //             bottom: 60,
        //             width: '80%',
        //             min: 0,
        //             max: 100,
        //             minSize: '0%',
        //             maxSize: '100%',
        //             sort: 'descending',
        //             gap: 2,
        //             label: {
        //                 show: true,
        //                 position: 'inside'
        //             },
        //             labelLine: {
        //                 length: 10,
        //                 lineStyle: {
        //                     width: 1,
        //                     type: 'solid'
        //                 }
        //             },
        //             itemStyle: {
        //                 borderColor: '#fff',
        //                 borderWidth: 1
        //             },
        //             emphasis: {
        //                 label: {
        //                     fontSize: 20
        //                 }
        //             },
        //             data: [
        //                 // { value: 60, name: 'Visit' },
        //                 // { value: 40, name: 'Inquiry' },
        //                 // { value: 20, name: 'Order' },
        //                 // { value: 80, name: 'Click' },
        //                 // { value: 100, name: 'Show' }
        //                 { value: ydata8[4], name: xdata8[4] },
        //                 { value: ydata8[3], name: xdata8[3] },
        //                 { value: ydata8[2], name: xdata8[2] },
        //                 { value: ydata8[1], name: xdata8[1] },
        //                 { value: ydata8[0], name: xdata8[0] }
        //             ]
        //         }
        //     ]
        // };





        // option = {
        //     //  backgroundColor: '#00265f',
        //     tooltip: {
        //         trigger: 'axis',
        //         axisPointer: {
        //             type: 'shadow'
        //         }
        //     },
        //
        //     grid: {
        //         left: '0%',
        //         top: '10px',
        //         right: '0%',
        //         bottom: '2%',
        //         containLabel: true
        //     },
        //     xAxis: [{
        //         type: 'category',
        //         data: ['浙江', '上海', '江苏', '广东', '北京', '深圳', '安徽', '四川'],
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLabel: {
        //             interval: 0,
        //             // rotate:50,
        //             show: true,
        //             splitNumber: 15,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //     }],
        //     yAxis: [{
        //         type: 'value',
        //         axisLabel: {
        //             //formatter: '{value} %'
        //             show: true,
        //             textStyle: {
        //                 color: "rgba(255,255,255,.6)",
        //                 fontSize: '12',
        //             },
        //         },
        //         axisTick: {
        //             show: false,
        //         },
        //         axisLine: {
        //             show: true,
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1	)",
        //                 width: 1,
        //                 type: "solid"
        //             },
        //         },
        //         splitLine: {
        //             lineStyle: {
        //                 color: "rgba(255,255,255,.1)",
        //             }
        //         }
        //     }],
        //     series: [{
        //         type: 'bar',
        //         data: [2, 3, 3, 9, 15, 12, 6, 4, 6, 7, 4, 10],
        //         barWidth: '35%', //柱子宽度
        //         // barGap: 1, //柱子之间间距
        //         itemStyle: {
        //             normal: {
        //                 color: '#2f89cf',
        //                 opacity: 1,
        //                 barBorderRadius: 5,
        //             }
        //         }
        //     }
        //     ]
        // };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }


    //乘客年龄分布
    function echarts_4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart4'));


        option = {
            // title:{
            //     text: "会话数",
            //     textStyle:{
            //       fontSize:12,
            //       Color:'#86909C'
            //     }

            //   },
            legend: {
                //data: ["会话人数", "成交人数"],
                data: ["人次"],
                bottom: "3%",
                textStyle:{color:"#fff" }
            },
            tooltip: {
                trigger: "axis",
                axisPointer: {
                    lineStyle: {
                        color: "#86909C", //显示竖线颜色
                        type: "dashed",
                    },
                },
                backgroundColor: "none", //tooltip背景色
                borderColor: "rgba(204,204,204,0.1)", //tooltip边框颜色
                borderWidth: 1,
                borderRadius: 4,
                width: 300,
                formatter: function (param) {
                    //自定义tooltip内容
                    // console.log("数据=========", param);
                    var text = "";
                    text += `<div style="background: rgba(204,204,204,0.1);border-radius:4px;padding:8px;backdrop-filter: blur(5px);box-shadow: 0px 0px 16px 0px rgba(29,48,92,0.15);"> 
                          <h2 style="color:#1D2129;font-size:12px;">数量</h2> 
                          <div  style="background:#ffffff;border-radius:6px;margin:4px;padding:4px 8px;color:#000000;margint-bottom:30px"> 
                            <b style="display:inline-block;width:8px;height:8px;border-radius:6px;background-color:${param[0].color}"></b>
                            <span style="color:#4E5969;">${param[0].seriesName} </span> 
                            <span style="float:right;color:#1D2129;font-size:12px;">${param[0].value}   </span> 
                          </div> 
                          <div  style="background:#ffffff;border-radius:6px;margin:4px;padding:4px 8px;color:#000000;margint-bottom:10px"> 
                            <b style="display:inline-block;width:8px;height:8px;border-radius:6px;background-color:${param[1].color}"></b>
                            <span style="color:#4E5969; margin-right:50px;">${param[1].seriesName} </span> 
                            <span style="float:right;color:#1D2129;font-size:12px;">${param[1].value}   </span> 
                          </div> 
                       </div>`;
                    return text;
                },
            },
            dataset: [{}],
            xAxis: {
                type: "category",
                boundaryGap: false,
                // data: [
                //     "2022-10-11",
                //     "2022-10-12",
                //     "2022-10-13",
                //     "2022-10-14",
                //     "2022-10-15",
                //     "2022-10-16",
                //     "2022-10-17",
                // ],
                data:xdata1,
                axisLine: {
                    //x轴
                    lineStyle: {
                        color: "#E5E6EB",
                    },
                },
                axisTick: {
                    //x轴刻度线
                    lineStyle: {
                        color: "#C9CDD4",
                    },
                },
                axisLabel: {
                    textStyle: {
                        color: "#86909C",
                    },
                },
            },
            yAxis: {
                type: "value",
                name: "人次",
                nameLocation: "end",
                nameTextStyle: {
                    color: "#86909C",
                    fontSize: 12,
                    //  align:"left"
                },
                axisLine: {
                    //y轴线
                    show: false,
                },
                axisTick: {
                    //y轴刻度
                    show: false,
                },
                axisLabel: {
                    // show :false,
                    color: "#86909C",
                },

                splitLine: {
                    lineStyle: {
                        color: "#E5E6EB",
                        width: 1,
                        type: "dashed",
                    },
                },
            },
            grid: {
                top: "10%",
                right: "6%",
                bottom: "12%",
                left: "3%",
                containLabel: true,
            },
            series: [
                {
                    type: "line",
                    name: "年龄",
                    showSymbol: false,
                    itemStyle: {
                        normal: {
                            color: "rgb(22,93,255)",
                            lineStyle: {
                                color: "rgb(22,93,255)",
                            },
                        },
                    },

                    data: xdata1
                },
                {
                    type: "line",
                    name: "人次",
                    showSymbol: false,
                    itemStyle: {
                        normal: {
                            color: "#1FA087",
                            lineStyle: {
                                color: "#1FA087",
                            },
                        },
                    },
                    // data: [220, 182, 191, 234, 290, 330, 310],
                     data: ydata1
                },
            ],
        }






        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echarts_6() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart6'));

        var dataStyle = {
            normal: {
                label: {
                    show: false
                },
                labelLine: {
                    show: false
                },
                //shadowBlur: 40,
                //shadowColor: 'rgba(40, 40, 40, 1)',
            }
        };
        var placeHolderStyle = {
            normal: {
                color: 'rgba(255,255,255,.05)',
                label: {show: false,},
                labelLine: {show: false}
            },
            emphasis: {
                color: 'rgba(0,0,0,0)'
            }
        };
        option = {
            color: ['#0f63d6', '#0f78d6', '#0f8cd6', '#0fa0d6', '#0fb4d6'],
            tooltip: {
                show: true,
                formatter: "{a} : {c} "
            },
            legend: {
                itemWidth: 10,
                itemHeight: 10,
                itemGap: 12,
                bottom: '3%',

                data: ['浙江', '上海', '广东', '北京', '深圳'],
                textStyle: {
                    color: 'rgba(255,255,255,.6)',
                }
            },

            series: [
                {
                    name: '浙江',
                    type: 'pie',
                    clockWise: false,
                    center: ['50%', '42%'],
                    radius: ['59%', '70%'],
                    itemStyle: dataStyle,
                    hoverAnimation: false,
                    data: [{
                        value: 80,
                        name: '01'
                    }, {
                        value: 20,
                        name: 'invisible',
                        tooltip: {show: false},
                        itemStyle: placeHolderStyle
                    }]
                },
                {
                    name: '上海',
                    type: 'pie',
                    clockWise: false,
                    center: ['50%', '42%'],
                    radius: ['49%', '60%'],
                    itemStyle: dataStyle,
                    hoverAnimation: false,
                    data: [{
                        value: 70,
                        name: '02'
                    }, {
                        value: 30,
                        name: 'invisible',
                        tooltip: {show: false},
                        itemStyle: placeHolderStyle
                    }]
                },
                {
                    name: '广东',
                    type: 'pie',
                    clockWise: false,
                    hoverAnimation: false,
                    center: ['50%', '42%'],
                    radius: ['39%', '50%'],
                    itemStyle: dataStyle,
                    data: [{
                        value: 65,
                        name: '03'
                    }, {
                        value: 35,
                        name: 'invisible',
                        tooltip: {show: false},
                        itemStyle: placeHolderStyle
                    }]
                },
                {
                    name: '北京',
                    type: 'pie',
                    clockWise: false,
                    hoverAnimation: false,
                    center: ['50%', '42%'],
                    radius: ['29%', '40%'],
                    itemStyle: dataStyle,
                    data: [{
                        value: 60,
                        name: '04'
                    }, {
                        value: 40,
                        name: 'invisible',
                        tooltip: {show: false},
                        itemStyle: placeHolderStyle
                    }]
                },
                {
                    name: '深圳',
                    type: 'pie',
                    clockWise: false,
                    hoverAnimation: false,
                    center: ['50%', '42%'],
                    radius: ['20%', '30%'],
                    itemStyle: dataStyle,
                    data: [{
                        value: 50,
                        name: '05'
                    }, {
                        value: 50,
                        name: 'invisible',
                        tooltip: {show: false},
                        itemStyle: placeHolderStyle
                    }]
                },]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echarts_31() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('fb1'));
        option = {

            title: [{
                text: '年龄分布',
                left: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize: '16'
                }

            }],
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)",
                position: function (p) {   //其中p为当前鼠标的位置
                    return [p[0] + 10, p[1] - 10];
                }
            },
            legend: {

                top: '70%',
                itemWidth: 10,
                itemHeight: 10,
                data: ['0岁以下', '20-29岁', '30-39岁', '40-49岁', '50岁以上'],
                textStyle: {
                    color: 'rgba(255,255,255,.5)',
                    fontSize: '12',
                }
            },
            series: [
                {
                    name: '年龄分布',
                    type: 'pie',
                    center: ['50%', '42%'],
                    radius: ['40%', '60%'],
                    color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                    label: {show: false},
                    labelLine: {show: false},
                    data: [
                        {value: 1, name: '0岁以下'},
                        {value: 4, name: '20-29岁'},
                        {value: 2, name: '30-39岁'},
                        {value: 2, name: '40-49岁'},
                        {value: 1, name: '50岁以上'},
                    ]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echarts_32() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('fb2'));
        option = {

            title: [{
                text: '职业分布',
                left: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize: '16'
                }

            }],
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)",
                position: function (p) {   //其中p为当前鼠标的位置
                    return [p[0] + 10, p[1] - 10];
                }
            },
            legend: {

                top: '70%',
                itemWidth: 10,
                itemHeight: 10,
                data: ['电子商务', '教育', 'IT/互联网', '金融', '学生', '其他'],
                textStyle: {
                    color: 'rgba(255,255,255,.5)',
                    fontSize: '12',
                }
            },
            series: [
                {
                    name: '年龄分布',
                    type: 'pie',
                    center: ['50%', '42%'],
                    radius: ['40%', '60%'],
                    color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                    label: {show: false},
                    labelLine: {show: false},
                    data: [
                        {value: 5, name: '电子商务'},
                        {value: 1, name: '教育'},
                        {value: 6, name: 'IT/互联网'},
                        {value: 2, name: '金融'},
                        {value: 1, name: '学生'},
                        {value: 1, name: '其他'},
                    ]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

    function echarts_33() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('fb3'));
        option = {
            title: [{
                text: '兴趣分布',
                left: 'center',
                textStyle: {
                    color: '#fff',
                    fontSize: '16'
                }

            }],
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)",
                position: function (p) {   //其中p为当前鼠标的位置
                    return [p[0] + 10, p[1] - 10];
                }
            },
            legend: {
                top: '70%',
                itemWidth: 10,
                itemHeight: 10,
                data: ['汽车', '旅游', '财经', '教育', '软件', '其他'],
                textStyle: {
                    color: 'rgba(255,255,255,.5)',
                    fontSize: '12',
                }
            },
            series: [
                {
                    name: '兴趣分布',
                    type: 'pie',
                    center: ['50%', '42%'],
                    radius: ['40%', '60%'],
                    color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                    label: {show: false},
                    labelLine: {show: false},
                    data: [
                        {value: 2, name: '汽车'},
                        {value: 3, name: '旅游'},
                        {value: 1, name: '财经'},
                        {value: 4, name: '教育'},
                        {value: 8, name: '软件'},
                        {value: 1, name: '其他'},
                    ]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }

})