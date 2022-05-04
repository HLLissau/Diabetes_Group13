export default class Backend {

  constructor() {
    this.url = "http://localhost:8080/api/v1"
  }

  getUrlHospitals() {
    return this.url + "/hospitals"
  }

  getUrlHospitalPatients(id) {
    return this.url + "/hospitals/" + id + "/patients"
  }

  getUrlPostHospital() {
    return this.url + "/hospitals"
  }

  getUrlPostPatient(id) {
    return this.url + "/hospitals/" + id + "/patients"
  }

  getUrlDeleteHospital(id) {
    return this.url + "/hospitals/" + id
  }

}