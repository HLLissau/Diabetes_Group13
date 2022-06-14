export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
    this.UserId = 2
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

  getUrlUsers() {
    return this.url + "/login/get/users"
  }

  getUrlHospitalPatients(id) {
    return this.url + "/hospitals/" + id + "/patients"
  }

  getUrlCreateUser() {
    return this.url + "/login/create/user"
  }

  getUrlPostPatient(id) {
    return this.url + "/hospitals/" + id + "/patients"
  }

  getUrlDeleteHospital(id) {
    return this.url + "/hospitals/" + id
  }
  getUrlByInterval(patient,after,before) {
    var link = this.url + "/patient/" + patient + "/getData/" + after + "/" + before
    return link
  }
  getUrlByUserIdbyHourBetween(patient,after,before) {
    var link =this.url + "/patient/" + patient + "/getData/average/byHour/" + after + "/" + before
    return link
  }
  n
  getUrlByUserIdbyDayBetween(patient,after,before) {
    var link =this.url + "/patient/" + patient + "/getData/average/byDay/" + after + "/" + before
    return link
  }
}