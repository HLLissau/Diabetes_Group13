export default class Backend {

    constructor() {
      this.url = "http://localhost:8080/api/v1"
    }
  
    getUrlHospitalList() {
      return this.url + "/hospitals"
    }
  
    getUrlPostHospital() {
      return this.url + "/hospitals"
    }
  
    getUrlDeleteHospital(id) {
      return this.url + "/hospitals/" + id
    }
  
  }