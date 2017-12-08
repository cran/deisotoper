package ch.fgcz.proteomics.R;

/**
 * @author Lucas Schmidt
 * @since 2017-11-20
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

// TODO: Finish tests for FeaturesBasedDeisotoping!
public class FeaturesBasedDeisotopingTest {
    @Test
    public void test() {
        // double[] mz = { 110.071701, 111.0749207, 113.071312, 114.1415176,
        // 115.0869827, 116.0710602, 120.0810928,
        // 127.0868988, 129.1024475, 129.8681793, 130.0653534, 130.0865326, 131.0686493,
        // 132.0809937, 136.0760803,
        // 136.2918549, 141.1024323, 145.0610046, 147.1129456, 148.1164246, 156.0809631,
        // 157.0973053, 159.0918427,
        // 160.0951996, 166.0615692, 167.4468231, 169.0972595, 169.1337585, 170.1369781,
        // 171.1129303, 172.3184357,
        // 173.1286774, 175.1191101, 178.1342621, 186.1239166, 187.086792, 187.1080933,
        // 187.1274872, 189.0692139,
        // 190.068573, 195.088028, 197.1287384, 198.1321716, 201.1025696, 204.1344147,
        // 206.1291199, 209.1399689,
        // 211.1445618, 214.1187286, 224.1035309, 225.1389313, 226.1190033, 227.1223297,
        // 228.1131744, 228.1342926,
        // 229.0973816, 231.1448822, 235.1193085, 237.1346893, 242.186554, 244.1296082,
        // 246.0908051, 246.1238251,
        // 254.1502075, 256.1080322, 257.0921021, 259.6817017, 260.1969604, 263.1503601,
        // 266.1499634, 267.1334229,
        // 270.1810608, 274.1185913, 275.1712341, 276.1020203, 282.1802368, 286.1550903,
        // 294.1564026, 295.4968567,
        // 297.1559753, 300.155304, 303.111969, 303.1289978, 310.1141968, 311.1713562,
        // 313.1297302, 313.1491699,
        // 313.1871033, 314.1125793, 314.1339722, 315.1662903, 322.1513672, 323.155304,
        // 323.1712646, 324.130127,
        // 325.1504211, 329.2183533, 330.1925964, 331.1401062, 335.1716919, 339.1679077,
        // 339.2026062, 341.1816101,
        // 342.1772461, 344.1088257, 345.1227417, 345.1593628, 347.2288818, 348.2323608,
        // 355.2129211, 357.1593018,
        // 361.2344666, 362.2189636, 373.1515808, 374.1851807, 374.2401428, 379.1362305,
        // 379.2453613, 380.1927795,
        // 380.2481689, 382.2437134, 383.2077026, 384.2115173, 386.1822205, 389.229187,
        // 390.1444702, 400.2554321,
        // 402.1802368, 406.1875916, 407.2401733, 408.2441406, 409.2459106, 410.2394409,
        // 413.2504272, 414.2711487,
        // 424.2195129, 428.177002, 428.2504883, 437.2157593, 441.2463684, 444.1914978,
        // 446.2976685, 447.2988892,
        // 448.1578979, 449.1611023, 452.2290649, 456.1916199, 461.2185059, 461.2878723,
        // 462.1820068, 466.1681824,
        // 470.2403259, 471.2446594, 472.1865845, 473.2192688, 473.3094788, 484.1782837,
        // 484.2579956, 485.3085938,
        // 487.2550049, 487.7567444, 488.7183228, 489.2131042, 496.1795349, 497.2192383,
        // 501.252533, 501.7550354,
        // 503.3190613, 504.2927246, 504.3226624, 509.2528381, 511.6417236, 515.2286987,
        // 523.7526855, 526.2089844,
        // 527.2633057, 528.2783813, 529.763855, 530.2653198, 530.7664185, 537.7512817,
        // 538.25, 542.2402954,
        // 543.2244873, 545.78302, 555.2533569, 559.196167, 560.2501831, 565.2373657,
        // 566.2391968, 572.2493896,
        // 574.3562622, 575.359375, 576.2244873, 576.3613892, 583.2484131, 584.2887573,
        // 584.9671021, 589.3826904,
        // 590.5994873, 590.9331665, 593.9641113, 594.2724609, 594.2979126, 594.630188,
        // 595.2662964, 599.2619019,
        // 600.2455444, 607.305603, 607.9355469, 608.8062134, 609.2649536, 609.3065796,
        // 609.8085938, 612.2493286,
        // 612.2817383, 612.9710083, 613.6070557, 616.3109741, 616.8139648, 617.270874,
        // 617.3770752, 618.3800659,
        // 622.8032837, 623.3052979, 623.3522949, 623.8049927, 624.8243408, 625.3269653,
        // 625.8259277, 629.3087769,
        // 630.2717896, 634.2229614, 640.3483276, 641.3391724, 649.8557129, 651.3134155,
        // 651.6471558, 651.9796143,
        // 652.2333374, 653.2374878, 657.2813721, 658.2669678, 658.3426514, 658.8430786,
        // 659.3056641, 670.2436523,
        // 671.3237915, 672.3380737, 672.8400879, 673.3391113, 673.4249878, 674.3200684,
        // 674.4285889, 674.6552124,
        // 674.9893799, 675.2924805, 675.3222046, 675.9883423, 680.3241577, 680.6589355,
        // 680.963623, 680.9923706,
        // 681.3302002, 686.399292, 687.3248901, 691.6608887, 691.9915161, 693.6622925,
        // 694.331604, 696.2972412,
        // 696.3302612, 697.3275146, 697.6620483, 697.9951782, 698.3287964, 698.6628418,
        // 698.9917603, 699.3157349,
        // 700.0021362, 700.3359985, 703.3307495, 703.6655273, 703.9990234, 704.3331299,
        // 704.4108887, 708.333252,
        // 709.333252, 709.6692505, 710.0016479, 716.3412476, 722.885376, 723.3878174,
        // 727.0216675, 727.3546753,
        // 728.8812256, 729.3815308, 731.352417, 733.0253906, 733.3601074, 733.6938477,
        // 736.3544312, 736.6879883,
        // 737.020874, 741.3170166, 742.6920166, 747.3061523, 751.3024292, 752.3051147,
        // 755.8552856, 757.3911743,
        // 757.8936157, 758.3939209, 765.3168945, 766.3220825, 769.3131104, 770.4434204,
        // 772.3446655, 773.3509521,
        // 773.8519287, 774.3530884, 775.043335, 779.3670044, 783.3291626, 787.4678955,
        // 788.4703369, 789.4733276,
        // 803.3713379, 808.3589478, 810.3719482, 816.8654175, 817.3688354, 821.9127808,
        // 822.4119873, 822.9143677,
        // 833.3647461, 838.369873, 840.3737183, 841.8769531, 842.3705444, 842.8764038,
        // 843.3744507, 851.3758545,
        // 851.8781738, 852.3798828, 854.3995972, 855.7609253, 860.3807373, 860.8851929,
        // 864.3909912, 864.4359741,
        // 865.3909912, 865.4417114, 870.0933838, 870.4278564, 871.4158325, 872.4161377,
        // 876.3934937, 876.4456177,
        // 876.9477539, 877.4489136, 882.3973999, 885.3942871, 886.9098511, 887.4129639,
        // 890.4420776, 890.9442139,
        // 891.4459229, 894.9141846, 895.9180298, 896.4204712, 896.9204712, 899.4361572,
        // 900.9120483, 901.4134521,
        // 901.4690552, 901.9152222, 902.4176025, 910.9036865, 911.4049683, 911.9036865,
        // 912.7774658, 918.0413208,
        // 918.5062866, 918.953125, 919.4586792, 919.5082397, 919.9053955, 919.9539185,
        // 920.40802, 920.512146,
        // 920.9060059, 927.9630127, 937.4363403, 938.4411621, 942.4500732, 951.4378662,
        // 955.9464111, 957.519104,
        // 960.4371948, 960.9343872, 961.44104, 963.4528198, 964.447937, 965.4516602,
        // 967.4605713, 968.4612427,
        // 969.4411011, 969.9401245, 970.442627, 975.5299072, 976.4676514, 976.5332031,
        // 976.9672241, 977.4685059,
        // 977.5324097, 977.9678955, 978.9451904, 979.4481201, 993.9794922, 994.4717407,
        // 996.9744873, 997.4754639,
        // 997.9810791, 1000.479309, 1001.500671, 1002.503418, 1003.501038, 1007.463684,
        // 1007.977295, 1008.479858,
        // 1010.977539, 1011.478149, 1011.979675, 1014.454529, 1019.983032, 1020.484802,
        // 1020.984436, 1021.488647,
        // 1029.488159, 1031.506226, 1035.000244, 1035.995483, 1036.481445, 1036.979492,
        // 1039.486328, 1039.993408,
        // 1040.495361, 1040.994995, 1041.498169, 1041.994507, 1044.552368, 1045.010376,
        // 1045.488525, 1045.550171,
        // 1045.989502, 1046.488159, 1046.990356, 1047.502686, 1047.983765, 1048.49231,
        // 1048.98999, 1049.502075,
        // 1049.997925, 1050.518311, 1051.519043, 1054.49292, 1054.994141, 1055.495117,
        // 1055.996826, 1056.497437,
        // 1058.521118, 1059.526001, 1062.562012, 1063.498413, 1063.566406, 1064.000366,
        // 1064.500732, 1064.568726,
        // 1065.000854, 1065.568481, 1068.507935, 1074.495605, 1076.506226, 1078.515015,
        // 1079.523438, 1080.520386,
        // 1080.806152, 1081.029297, 1082.525391, 1084.530151, 1086.513916, 1090.027222,
        // 1090.530396, 1091.032837,
        // 1091.539063, 1095.019775, 1095.52356, 1096.024414, 1098.53125, 1099.033569,
        // 1099.537109, 1100.037842,
        // 1100.539429, 1101.0271, 1104.026611, 1104.52832, 1105.029419, 1105.529541,
        // 1106.03418, 1107.484497,
        // 1108.483765, 1112.535522, 1113.032104, 1113.532959, 1114.035034, 1114.534302,
        // 1115.041138, 1125.496826,
        // 1131.057617, 1136.033691, 1140.056274, 1145.037842, 1149.535522, 1152.552124,
        // 1153.056763, 1153.558472,
        // 1161.55957, 1162.062256, 1162.558472, 1163.064453, 1167.555664, 1197.094727,
        // 1197.603394, 1198.099243,
        // 1198.600952, 1202.089355, 1202.591553, 1203.088745, 1207.557739, 1211.093872,
        // 1211.593628, 1212.094971,
        // 1212.597778, 1213.094849, 1216.608032, 1217.601318, 1230.632935, 1231.629639,
        // 1232.623169, 1236.588013,
        // 1237.586792, 1244.602905, 1245.603638, 1248.641968, 1249.643555, 1250.646484,
        // 1251.645386, 1274.11853,
        // 1274.617676, 1290.639282, 1312.746948, 1315.680542, 1316.679443, 1339.143433,
        // 1339.656006, 1340.146606,
        // 1343.672363, 1344.673828, 1345.670776, 1347.713379, 1348.716187, 1368.15271,
        // 1373.640381, 1374.643677,
        // 1376.156982, 1376.675781, 1427.753052, 1428.75415, 1444.764038, 1445.766357,
        // 1446.765015, 1456.752563,
        // 1457.755737, 1458.760498, 1513.773315, 1545.686035, 1546.695923, 1559.109497,
        // 1642.819092, 1643.821167,
        // 1644.824951, 1645.83374, 1683.733154, 1684.745361, 1685.75, 1701.746094,
        // 1702.750122, 1703.753052,
        // 1704.763672, 1720.752441, 1779.873779, 1790.826538, 1791.828247, 1800.816162,
        // 1801.819336, 1802.821533,
        // 1818.827271, 1819.822632, 2014.950317, 2015.95459, 3704.048584, 3704.838867
        // };
        // double[] intensity = { 67613.671875, 1831.9465332031, 999.1885986328,
        // 958.4008789063, 1009.7340087891,
        // 1825.5847167969, 3966.4675292969, 1351.3416748047, 12182.810546875,
        // 820.7251586914, 50839.9453125,
        // 10942.630859375, 3394.8950195313, 14558.849609375, 2007.9077148438,
        // 856.5766601563, 1737.4708251953,
        // 1322.9926757813, 22451.431640625, 1391.1329345703, 962.4296875,
        // 1605.8873291016, 170024.8125,
        // 12487.916015625, 1660.4964599609, 815.3684692383, 1365.0274658203,
        // 71656.28125, 4688.6533203125,
        // 3498.9609375, 836.457824707, 3566.8562011719, 826.658203125, 5253.681640625,
        // 14340.4482421875,
        // 1761.1831054688, 1354.2014160156, 1605.0234375, 3294.0256347656,
        // 967.9634399414, 1873.9647216797,
        // 38019.03515625, 3443.1926269531, 1046.3061523438, 3608.8366699219,
        // 4732.384765625, 2094.5964355469,
        // 1036.67578125, 9351.779296875, 1055.6995849609, 1295.9558105469,
        // 4108.091796875, 1225.9825439453,
        // 1251.7897949219, 3176.5747070313, 1577.9881591797, 936.434753418,
        // 7339.546875, 4027.986328125,
        // 1431.4146728516, 3395.1850585938, 4719.8984375, 4817.9555664063,
        // 924.7261352539, 1573.5100097656,
        // 5306.6904296875, 952.1651611328, 8859.248046875, 5049.2109375,
        // 4426.1528320313, 1125.5798339844,
        // 992.5237426758, 10431.1689453125, 5023.029296875, 1008.2269287109,
        // 1001.2357788086, 1712.2807617188,
        // 3811.3051757813, 778.0229492188, 4415.9418945313, 1179.8687744141,
        // 4172.1923828125, 700.6480712891,
        // 3647.6672363281, 1882.4956054688, 8040.0864257813, 935.1657714844,
        // 915.0415039063, 863.4573364258,
        // 855.5131225586, 3719.1784667969, 1580.4450683594, 830.8236083984,
        // 4327.2377929688, 1468.5124511719,
        // 1462.2341308594, 1198.4080810547, 1605.6645507813, 1775.4102783203,
        // 1556.4569091797, 866.1019897461,
        // 4526.7900390625, 1763.3646240234, 8289.9013671875, 823.8076171875,
        // 1276.4318847656, 1604.6634521484,
        // 44400.56640625, 6639.1899414063, 1967.6704101563, 946.6687011719,
        // 1094.1202392578, 3578.7458496094,
        // 1435.3666992188, 3443.7131347656, 1041.2733154297, 1823.7592773438,
        // 35905.96484375, 1437.9211425781,
        // 5136.4462890625, 1225.8950195313, 14152.7119140625, 2050.1188964844,
        // 1426.9207763672, 951.7576293945,
        // 4704.3745117188, 1455.4357910156, 3697.1135253906, 953.5454101563,
        // 73513.28125, 9869.71875,
        // 1730.7620849609, 4764.7265625, 1081.1180419922, 1131.2509765625,
        // 1146.6674804688, 1294.9165039063,
        // 3573.8493652344, 1508.3453369141, 4031.9606933594, 1451.2650146484,
        // 7929.5493164063, 1017.5032958984,
        // 1862.6419677734, 895.2436523438, 3725.5588378906, 1552.1726074219,
        // 1190.9484863281, 1117.0860595703,
        // 1405.5310058594, 3731.0222167969, 8610.9375, 940.0627441406, 3510.90234375,
        // 1835.7896728516,
        // 1201.5424804688, 1299.4645996094, 1098.6483154297, 843.2536621094,
        // 8828.162109375, 1963.3797607422,
        // 1075.6431884766, 6058.390625, 1744.6840820313, 942.5045776367,
        // 6834.0810546875, 1848.6473388672,
        // 42207.390625, 1621.8843994141, 9898.6220703125, 1873.8389892578,
        // 948.9799804688, 1111.1832275391,
        // 1000.5302734375, 1179.3374023438, 4011.4028320313, 1464.4713134766,
        // 12671.3486328125, 4034.0246582031,
        // 1043.2894287109, 2100.6787109375, 1106.0621337891, 1268.5225830078,
        // 1902.9477539063, 834.6474609375,
        // 3748.8713378906, 3715.6154785156, 1144.4217529297, 6517.1352539063,
        // 1399.7967529297, 924.2121582031,
        // 69331.328125, 17037.453125, 1628.90234375, 1434.5238037109, 3936.4692382813,
        // 950.1052856445,
        // 1042.3439941406, 1743.4653320313, 977.1047973633, 960.9440917969,
        // 1613.6340332031, 875.8720703125,
        // 3557.8122558594, 857.7406616211, 2102.2802734375, 1896.6119384766,
        // 4195.224609375, 1777.6926269531,
        // 997.5719604492, 9931.87890625, 1873.0654296875, 7053.4243164063,
        // 2038.0284423828, 977.6705322266,
        // 1612.5084228516, 3908.1884765625, 1116.2249755859, 9910.85546875,
        // 4256.3247070313, 1891.8089599609,
        // 7618.1352539063, 1588.4603271484, 11892.5009765625, 7922.3549804688,
        // 1177.6960449219, 1233.4965820313,
        // 4000.65625, 1971.0622558594, 1144.8709716797, 3838.0417480469,
        // 3650.5439453125, 4021.9497070313,
        // 1028.8641357422, 933.4574584961, 1161.5887451172, 11866.025390625,
        // 11730.61328125, 8505.388671875,
        // 4334.0034179688, 1571.8179931641, 1222.861328125, 4181.6264648438,
        // 3500.0158691406, 4356.9150390625,
        // 964.7109375, 1131.0045166016, 1385.6940917969, 17401.32421875, 8147.52734375,
        // 5191.951171875,
        // 21055.20703125, 4795.2631835938, 7016.205078125, 5540.0209960938,
        // 3746.4609375, 3813.4887695313,
        // 1868.4936523438, 1174.4085693359, 10542.578125, 12092.177734375,
        // 1225.3231201172, 8095.9526367188,
        // 3227.25390625, 1589.4213867188, 1295.8977050781, 1608.7247314453,
        // 1717.8787841797, 3697.5788574219,
        // 1687.7242431641, 1518.0079345703, 1049.7507324219, 28697.58984375,
        // 32610.123046875, 20141.548828125,
        // 6863.3876953125, 1467.6721191406, 1263.6749267578, 3579.3857421875,
        // 3744.0537109375, 4038.5363769531,
        // 42395.4921875, 41557.8203125, 21450.4765625, 8526.8427734375,
        // 4392.0654296875, 1527.1987304688,
        // 8351.9599609375, 10923.126953125, 8195.490234375, 8294.0166015625,
        // 10410.6640625, 8898.20703125,
        // 6721.0126953125, 3463.333984375, 1438.3759765625, 6360.5078125,
        // 984.6576538086, 4657.3266601563,
        // 8838.3857421875, 5425.056640625, 11785.9912109375, 11700.1650390625,
        // 7951.2866210938, 1709.7021484375,
        // 3664.91015625, 1931.9256591797, 7128.109375, 1587.5677490234,
        // 1173.5155029297, 1378.2398681641,
        // 1444.5145263672, 1730.3620605469, 5569.734375, 1122.876953125,
        // 2124.0432128906, 3521.9382324219,
        // 5712.3891601563, 6410.4106445313, 1675.9910888672, 1069.2980957031,
        // 4169.3125, 1363.3560791016,
        // 1350.7581787109, 34752.70703125, 11545.6162109375, 1503.767578125,
        // 1353.6374511719, 1316.2670898438,
        // 1351.3453369141, 3812.3640136719, 1698.4130859375, 8076.8422851563,
        // 7031.2348632813, 5038.1411132813,
        // 1013.2843017578, 3763.9240722656, 1647.3623046875, 1327.1331787109,
        // 8387.7451171875, 7701.0517578125,
        // 4320.9033203125, 12654.177734375, 11012.5, 1971.1854248047, 4827.4790039063,
        // 1124.4234619141,
        // 1866.1986083984, 3766.3188476563, 7568.9580078125, 8040.0034179688,
        // 1650.9626464844, 2914.7033691406,
        // 1921.0505371094, 2089.9423828125, 5269.1821289063, 1332.2758789063,
        // 1240.2318115234, 4831.001953125,
        // 5465.8325195313, 1048.6594238281, 4384.263671875, 1300.1697998047,
        // 1123.3106689453, 1361.1683349609,
        // 14360.2744140625, 8876.24609375, 3995.9702148438, 1307.1307373047,
        // 4446.916015625, 3446.712890625,
        // 1353.5421142578, 1177.6708984375, 8276.275390625, 5276.1499023438,
        // 1212.6909179688, 1191.4787597656,
        // 4575.298828125, 2075.0822753906, 3819.287109375, 1309.4663085938,
        // 1419.3110351563, 3071.8327636719,
        // 23697.59375, 3762.7653808594, 6431.6264648438, 7176.1220703125,
        // 3925.6101074219, 1090.9129638672,
        // 2097.3466796875, 1347.7740478516, 3411.7290039063, 3431.7861328125,
        // 5340.994140625, 1852.5231933594,
        // 1746.2845458984, 1126.9534912109, 1785.8309326172, 1453.5706787109,
        // 3468.7690429688, 1930.2518310547,
        // 1661.228515625, 4634.259765625, 3929.1928710938, 1459.2158203125,
        // 1838.2846679688, 2002.5455322266,
        // 5111.5932617188, 5053.2260742188, 1333.640625, 67653.7734375,
        // 14176.068359375, 25679.259765625,
        // 21781.587890625, 11401.591796875, 5983.78125, 2060.5275878906,
        // 1334.3021240234, 1852.6478271484,
        // 1053.5278320313, 1056.0535888672, 1065.09765625, 1419.2072753906,
        // 1369.3054199219, 1258.9128417969,
        // 9635.0419921875, 1377.5627441406, 1896.4713134766, 901.6781616211,
        // 1636.8104248047, 1504.0844726563,
        // 10244.671875, 9501.1240234375, 5926.0981445313, 1003.0361938477,
        // 11722.3798828125, 10594.1884765625,
        // 5657.9287109375, 1125.4777832031, 990.3666992188, 1257.4001464844,
        // 1038.5245361328, 1552.7928466797,
        // 1945.0150146484, 1675.6466064453, 3548.595703125, 1287.2420654297,
        // 7584.8100585938, 5986.6630859375,
        // 5307.4858398438, 1598.3850097656, 5792.1904296875, 1035.7362060547,
        // 21022.986328125, 2816.1962890625,
        // 29567.01953125, 12437.767578125, 6346.8173828125, 1697.0704345703,
        // 1139.6850585938, 4342.05078125,
        // 1101.6555175781, 4137.2646484375, 7001.8383789063, 7450.8920898438,
        // 1844.3972167969, 46591.42578125,
        // 53875.75390625, 27965.853515625, 12799.0849609375, 1486.0028076172,
        // 3496.5556640625, 4040.9650878906,
        // 69656.40625, 15916.6220703125, 32769.18359375, 26351.953125, 12287.826171875,
        // 11873.8115234375,
        // 5757.533203125, 1507.4136962891, 1590.2685546875, 1105.1666259766,
        // 1644.2016601563, 3845.2897949219,
        // 1577.396484375, 1382.6195068359, 958.8025512695, 1509.9722900391,
        // 1502.0208740234, 1393.5240478516,
        // 1398.1911621094, 12246.8232421875, 16068.87109375, 9513.73046875,
        // 2652.6105957031, 5985.78515625,
        // 9609.3359375, 1711.3336181641, 5758.61328125, 22942.10546875,
        // 28251.693359375, 15892.2275390625,
        // 4276.1005859375, 1098.1518554688, 62993.7109375, 76822.1796875,
        // 45731.8828125, 16688.46484375,
        // 3593.5549316406, 1601.8675537109, 1082.4737548828, 1049.5546875,
        // 48567.3359375, 49414.4609375,
        // 26510.427734375, 10042.5791015625, 1928.2321777344, 1364.0875244141,
        // 1379.0983886719, 1051.0078125,
        // 1592.8907470703, 1167.6193847656, 1667.6839599609, 4481.0166015625,
        // 1985.1275634766, 1897.2416992188,
        // 7234.30859375, 9681.66796875, 3876.7641601563, 1759.6812744141,
        // 1144.9030761719, 6509.0859375,
        // 6640.9287109375, 8578.3525390625, 1543.8883056641, 3737.509765625,
        // 3506.3515625, 1044.8107910156,
        // 1125.4560546875, 25235.189453125, 32663.890625, 19117.005859375,
        // 10095.1240234375, 1420.8492431641,
        // 1800.1805419922, 1100.8802490234, 3973.0207519531, 3631.2604980469,
        // 3919.083984375, 6586.3974609375,
        // 1920.9197998047, 7040.1791992188, 1632.4958496094, 55801.0625,
        // 30595.806640625, 9000.96875,
        // 3344.1628417969, 3384.78515625, 3688.1376953125, 1301.1402587891,
        // 1240.0732421875, 1316.4320068359,
        // 1497.4797363281, 1581.4860839844, 1384.4041748047, 1241.3525390625,
        // 11051.4404296875, 10548.44921875,
        // 1888.7368164063, 7026.2783203125, 3786.4848632813, 1467.5749511719,
        // 1106.9543457031, 1319.2423095703,
        // 1074.6340332031, 1109.8099365234, 1770.2413330078, 1301.8181152344,
        // 21688.29296875, 14569.9580078125,
        // 7291.79296875, 11158.126953125, 8758.1328125, 3891.57421875, 1810.9868164063,
        // 1755.0939941406,
        // 1523.9315185547, 1108.177734375, 11509.0380859375, 8212.3173828125,
        // 4788.3774414063, 1208.1584472656,
        // 3808.3190917969, 1204.9481201172, 1501.1110839844, 4118.5512695313,
        // 4219.8735351563, 1431.0915527344,
        // 999.6631469727, 1256.4339599609, 1322.5466308594, 2959.7475585938,
        // 1908.0208740234, 5398.2744140625,
        // 4858.6484375, 1337.1431884766, 4596.2534179688, 3689.3454589844,
        // 1335.6721191406, 1296.7269287109,
        // 1259.4842529297, 1252.899291992 };

        // double[] mz = { 0.2, 1.0, 2.0, 2.5, 4.0, 5.0, 6.0, 7.0, 9.0, 10.0, 11.0,
        // 12.0, 13.0, 17.0, 18.0, 19.0, 21.0,
        // 23.0, 111.0 };
        // double[] intensity = { 0.2, 1.0, 2.0, 2.5, 4.0, 5.0, 6.0, 7.0, 9.0, 10.0,
        // 11.0, 12.0, 13.0, 17.0, 18.0, 19.0,
        // 21.0, 23.0, 111.0 };

        double[] mz = { 1.0, 2.0, 2.5, 3.0 };
        double[] intensity = { 1.0, 1.0, 1.0, 1.0 };
        double[] mz2 = { 1.01, 2.0, 2.5, 3.0 };
        double[] intensity2 = { 1.0, 1.0, 1.0, 1.0 };

        // double[] mz = { 1011.0, 1012.0, 1015.0, 1016.0 };
        // double[] intensity = { 1.0, 1.0, 1.0, 1.0 };

        FeaturesBasedDeisotoping dtoper = new FeaturesBasedDeisotoping();

        double[] aa = { 99.06841 };

        dtoper.setConfiguration(aa, 0.8, 0.5, 0.1, 0.1, 0.1, 0.003, 0.3, 1.0, 0, false, "first");

        dtoper.setMz(mz);
        dtoper.setIntensity(intensity);
        dtoper.setPepMass(600);
        dtoper.setCharge(2);

        dtoper.deisotope();

        double[] mzout = dtoper.getMz();
        double[] intensityout = dtoper.getIntensity();

        System.out.println("Input Peaklist (" + mz.length + "):   Output Peaklist(" + mzout.length + "):");
        for (int i = 0; i < mz.length || i < intensity.length; i++) {
            System.out.print(mz[i] + " ");
            System.out.print(intensity[i] + "    ");
            if (i < mzout.length || i < intensityout.length) {
                System.out.print(mzout[i] + " ");
                System.out.print(intensityout[i]);
            } else {
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();

        dtoper.setMz(mz2);
        dtoper.setIntensity(intensity2);
        dtoper.setPepMass(600);
        dtoper.setCharge(2);

        dtoper.deisotope();

        double[] mzout2 = dtoper.getMz();
        double[] intensityout2 = dtoper.getIntensity();

        System.out.println("Input Peaklist (" + mz2.length + "):   Output Peaklist(" + mzout2.length + "):");
        for (int i = 0; i < mz2.length || i < intensity2.length; i++) {
            System.out.print(mz2[i] + " ");
            System.out.print(intensity2[i] + "    ");
            if (i < mzout2.length || i < intensityout2.length) {
                System.out.print(mzout2[i] + " ");
                System.out.print(intensityout2[i]);
            } else {
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
        // System.out.println("Peaks who are in input and not anymore in output:");
        // List<Double> mzlist = new ArrayList();
        // List<Double> intensitylist = new ArrayList();
        // List<Double> mzoutlist = new ArrayList();
        // List<Double> intensityoutlist = new ArrayList();
        // for (int i = 0; i < mz.length; i++) {
        // mzlist.add(mz[i]);
        // intensitylist.add(intensity[i]);
        // }
        //
        // for (int i = 0; i < mzout.length; i++) {
        // mzoutlist.add(mzout[i]);
        // intensityoutlist.add(intensityout[i]);
        // }
        //
        // mzlist.removeAll(mzoutlist);
        // intensitylist.removeAll(intensityoutlist);
        //
        // for (int i = 0; i < mzlist.size(); i++) {
        // System.out.println(mzlist.get(i) + " " + intensitylist.get(i));
        // }
        // System.out.println();
        // System.out.println(dtoper.getSummary());
        // System.out.println();
        // System.out.println(dtoper.getAnnotatedSpectrum());
        //
        // System.out.println();
        // for (String dot : dtoper.getDot()) {
        // System.out.println(dot);
        // }
        // dtoper.setMz(mz2);
        // dtoper.setIntensity(intensity2);
        // dtoper.setPepMass(1.2345);
        // dtoper.setCharge(2);
        //
        // dtoper.deisotope();
        //
        // double[] mzout2 = dtoper.getMz();
        // double[] intensityout2 = dtoper.getIntensity();
        //
        // System.out.println("Input Peaklist (" + mz2.length + "): Output Peaklist(" +
        // mzout2.length + "):");
        // for (int i = 0; i < mz2.length || i < intensity2.length; i++) {
        // System.out.print(mz2[i] + " ");
        // System.out.print(intensity2[i] + " ");
        // if (i < mzout2.length || i < intensityout2.length) {
        // System.out.print(mzout2[i] + " ");
        // System.out.print(intensityout2[i]);
        // } else {
        // System.out.print(" ");
        // }
        //
        // System.out.println();
        // }
        // System.out.println();
        //
        // System.out.println("Peaks who are in input and not anymore in output:");
        // List<Double> mzlist2 = new ArrayList();
        // List<Double> intensitylist2 = new ArrayList();
        // List<Double> mzoutlist2 = new ArrayList();
        // List<Double> intensityoutlist2 = new ArrayList();
        // for (int i = 0; i < mz.length; i++) {
        // mzlist2.add(mz[i]);
        // intensitylist2.add(intensity[i]);
        // }
        //
        // for (int i = 0; i < mzout2.length; i++) {
        // mzoutlist2.add(mzout2[i]);
        // intensityoutlist2.add(intensityout2[i]);
        // }
        //
        // mzlist2.removeAll(mzoutlist2);
        // intensitylist2.removeAll(intensityoutlist2);
        //
        // for (int i = 0; i < mzlist2.size(); i++) {
        // System.out.println(mzlist2.get(i) + " " + intensitylist2.get(i));
        // }
        // System.out.println();
        // System.out.println(dtoper.getSummary());
        // System.out.println();
        // System.out.println(dtoper.getConfiguration());
        // System.out.println();
        // System.out.println(dtoper.getAnnotatedSpectrum());
        // System.out.println();
        // System.out.println(dtoper.getDot()[1]);
    }

    @Test
    public void randomTest() {
        for (int x = 0; x < 3; x++) {
            double[] mz = generateRandomMz();
            double[] intensity = generateRandomIntensity();
            double pepMass = generateRandomPepMass();

            FeaturesBasedDeisotoping dtoper = new FeaturesBasedDeisotoping();

            double[] aa = { 99.06841 };

            dtoper.setConfiguration(aa, 0.8, 0.5, 0.1, 0.1, 0.1, 0.003, 0.3, 1.0, 0, false, "first");

            dtoper.setMz(mz);
            dtoper.setIntensity(intensity);
            dtoper.setPepMass(pepMass);
            dtoper.setCharge(2);

            dtoper.deisotope();

            double[] mzout = dtoper.getMz();
            double[] intensityout = dtoper.getIntensity();

            // System.out.println("Input Peaklist (" + mz.length + "): Output Peaklist(" +
            // mzout.length + "):");
            // for (int i = 0; i < mz.length || i < intensity.length; i++) {
            // System.out.print(mz[i] + " ");
            // System.out.print(intensity[i] + " ");
            // if (i < mzout.length || i < intensityout.length) {
            // System.out.print(mzout[i] + " ");
            // System.out.print(intensityout[i]);
            // } else {
            // System.out.print(" ");
            // }
            //
            // System.out.println();
            // }
            // System.out.println();
            //
            // System.out.println(pepMass);

            double before = sum(intensity);
            double after = sum(intensityout);

            // System.out.println("difference: " + Math.abs(before - after));

            assertEquals(before, after, 0.0001);
        }
    }

    private double sum(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    private double generateRandom(double min, double max) {
        Random random = new Random();
        double randomValue = min + (max - min) * random.nextDouble();

        return (double) Math.round(randomValue * 1000d) / 1000d;
    }

    private double generateRandomPepMass() {
        return generateRandom(100, 1500);
    }

    private double[] generateRandomIntensity() {
        double[] intensity = new double[300];

        for (int i = 0; i < intensity.length; i++) {
            intensity[i] = generateRandom(100, 10000);
        }

        return intensity;
    }

    private double[] generateRandomMz() {
        double[] mz = new double[300];

        for (int i = 0; i < mz.length; i++) {
            mz[i] = generateRandom(120, 1000);
        }

        Arrays.sort(mz);

        return mz;
    }
}