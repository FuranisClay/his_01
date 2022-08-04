//转换mysql的datetime日期时间格式
function makeDate(date) {
  try {
    let newDate = new Date(date);
    //在小于10的月份前补0
    let month = eval(newDate.getMonth()+1) < 10 ? '0'+eval(newDate.getMonth()+1) : eval(newDate.getMonth() + 1);
    //在小于10的日期前补0
    let day = newDate.getDate() < 10 ? '0' + newDate.getDate() : newDate.getDate();
    //在小于10的小时前补0
    let hours = newDate.getHours() < 10 ? '0' + newDate.getHours() : newDate.getHours();
    //在小于10的分钟前补0
    let minutes = newDate.getMinutes() < 10 ? '0' + newDate.getMinutes() : newDate.getMinutes();
    //在小于10的秒数前补0
    let seconds = newDate.getSeconds() < 10 ? '0' + newDate.getSeconds(): newDate.getSeconds();
    //拼接时间
    let stringDate = newDate.getFullYear() + '-' + month + '-' + day + " " + hours + ":" + minutes + ":" + seconds;
    return stringDate;
  }catch(e){
    let stringDate1 = "0000-00-00 00:00:00";
    return stringDate1;
  }

}

function makeSimpleDate(date) {
  try {
    var newDate = new Date(date);
    //在小于10的月份前补0
    var month = eval(newDate.getMonth()+1) < 10 ? '0'+eval(newDate.getMonth()+1) : eval(newDate.getMonth() + 1);
    //在小于10的日期前补0
    var day = newDate.getDate() < 10 ? '0' + newDate.getDate() : newDate.getDate();
    //拼接时间
    var stringDate = newDate.getFullYear() + '-' + month + '-' + day;
    return stringDate;
  }catch(e){
    return "0000-00-00";
  }
}

//部门类型转换
function makeDeptType(dept) {

  var type = ""

  switch (dept) {
    case 1 : {
      type = "临床";
      break;
    }
    case 2 : {
      type = "医技";
      break;
    }
    case 3 : {
      type = "财务";
      break;
    }
    case 4 : {
      type = "行政";
      break;
    }
    default :
      type = "其它";

  }
  return type
}

//用户类型转换
function makeUserType(user) {

  var type = ""

  switch (user) {
    case 0 : {
      type = "root";
      break;
    }
    case 1 : {
      type = "医院管理员";
      break;
    }
    case 2 : {
      type = "挂号收费员";
      break;
    }
    case 3 : {
      type = "门诊医生";
      break;
    }
    case 4 : {
      type = "医技医生";
      break;
    }
    case 5 : {
      type = "药房操作员";
      break;
    }
    case 6 : {
      type = "财务管理员";
      break;
    }
    default :
      type = "其它";

  }
  return type
}
//项目类型转换
function makeRecordType(record) {

  var type = ""

  switch (record) {
    case 1 : {
      type = "检查";
      break;
    }
    case 2 : {
      type = "检验";
      break;
    }
    case 3 : {
      type = "处置";
      break;
    }
    default :
      type = "其它";

  }
  return type
}

//“是否”转换
function makeYNType(char) {

  var type = 0

  switch (char) {
    case '是' : {
      type = 1;
      break;
    }
    case '否' : {
      type = 0;
      break;
    }
  }
  return type
}



export {

  makeDeptType,
  makeUserType,
  makeSimpleDate,
  makeDate,
  makeRecordType,
  makeYNType

}
