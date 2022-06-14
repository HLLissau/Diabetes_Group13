export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
    this.UserId = 0
    this.password = ""

  }

  getAllData() {
    return this.url + "/patient/" + this.UserId + "/getData/average/byDay"
  }

  getUserId() {
    return this.UserId
  }
  setUserId(UserId) {
     this.UserId = UserId
  }
  getUserpassword() {
    return this.password
  }
  setUserpassword(password) {
     this.password = password
  }

  getUrlUsers() {
    return this.url + "/login/get/users"
  }

  getUrlHospitalPatients() {
    return this.url + "/hospitals/" + this.UserId + "/patients"
  }

  getUrlCreateUser() {
    return this.url + "/login/create/user"
  }

  getUrlPostPatient() {
    return this.url + "/hospitals/" + this.UserId + "/patients"
  }

  getUrlDeleteHospital() {
    return this.url + "/hospitals/" + this.UserId
  }
  getUrlByInterval(after,before) {
    var link = this.url + "/patient/" + this.UserId + "/getData/" + after + "/" + before
    return link
  }
  getUrlByUserIdbyHourBetween(after,before) {
    var link =this.url + "/patient/" + this.UserId + "/getData/average/byHour/" + after + "/" + before
    return link
  }
  
  getUrlByUserIdbyDayBetween(after,before) {
    var link =this.url + "/patient/" + this.UserId + "/getData/average/byDay/" + after + "/" + before
    return link
  }
  getUrlLoginUser(){
    var link = this.url + "/login/loginUser"
    return link
  }

  getUrlAveragesByHour(startDate, endDate) {
    console.log("url",this.url + "patient/" + 2 + "/getData/average/byHour/"+ startDate + "/" + endDate)
    return this.url + "/patient/" + 2 + "/getData/average/byHour/"+ startDate + "/" + endDate
  }

}