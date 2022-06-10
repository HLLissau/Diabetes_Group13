export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
  }

  getAllData() {
    return this.url + "/patient/" + 2 + "/getData/average/byDay"
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
    console.log("get:" , link)
    return link
  }
  getUrlByUserIdByHourBetween(patient,after,before) {
    var link =this.url + "/patient/" + patient + "/getData/average/byHour/" + after + "/" + before
    console.log("get2:" , link)
    return link
  }
  

}