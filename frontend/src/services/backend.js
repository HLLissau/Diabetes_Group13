export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
  }

  getUrlHospitalList() {
    return this.url + "/patients"
  }

  getUrlPostHospital() {
    return this.url + "/patients"
  }

  getUrlDeleteHospital(id) {
    return this.url + "/hospitals/" + id
  }

}