export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
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

}