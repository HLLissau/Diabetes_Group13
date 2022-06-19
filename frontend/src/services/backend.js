import moment from 'moment'
  
export default class Backend {
    access() {
    
     let user = new user({
      id : 0,
      fullName : "",
      createdAt: "",
      password : "",
      email : ""
    })
    

    let doctor = new doctor({
      id : 0,
      fullName : "",
      password : "",
      createdAt: "",
      email : ""
    })
    



    }
  constructor() {
    this.url = "http://localhost:8080/api/v1"
    
    
   
    
    

  }

  getAllData() {
    return this.url + "/patient/" + this.user.id + "/getData/average/byDay"
  }

  getUser() {
    return this.user
  }

  getDoctorOfUser(){
    return this.url + "/patient/getDoctor/" + this.user.id
  }

  getUrlUpdateUser(id, name, email, password){
    return this.url + "/user/update/" + id + "/" + name + "/" + email + "/" + password
  }

/*
  getUserId() {
    return this.UserId
  }
  setUserId(UserId) {
     this.user.UserId = UserId
  }
  getUserName() {
    return this.UserName
  }
  setUserName(UserName) {
     this.UserName = UserName
  }
  getUserEmail() {
    return this.email
  }
  setUserEmail(email) {
     this.email = email
  }
  
  getDoctorId() {
    return this.doctorId
  }
  setDoctorId(doctorId) {
     this.doctorId = doctorId
  }
  getDoctorName() {
    return this.doctorName
  }
  setDoctorName(doctorName) {
     this.doctorName = doctorName
  }
  getDoctorEmail() {
    return this.email
  }
  setDoctorEmail(email) {
     this.email = email
  }

  getDoctorpassword() {
    return this.password
  }
  setDoctorpassword(password) {
     this.password = password
  }

  getUserpassword() {
    return this.password
  }
  setUserpassword(password) {
     this.password = password
  }
  */

  getUrlUsers() {
    return this.url + "/login/get/users"
  }

  getUrlHospitalPatients() {
    return this.url + "/hospitals/" + this.user.id + "/patients"
  }

  getUrlCreateUserAccount(){
    var link = this.url + "/patient/create"
    return link
  }
  getUrlCreateDoctorAccount(){
    var link = this.url + "/doctor/create"
    return link
  }


  getUrlPostPatient() {
    return this.url + "/hospitals/" + this.user.id + "/patients"
  }

  getUrlDeleteHospital() {
    return this.url + "/hospitals/" + this.user.id
  }
  getUrlByInterval(after,before) {
    var link = this.url + "/patient/" + this.user.id + "/getData/" + after + "/" + before
    return link
  }
  getUrlByUserIdbyHourBetween(after,before) {
    var link =this.url + "/patient/" + this.user.id + "/getData/average/byHour/" + after + "/" + before
    return link
  }
  
  getUrlByUserIdbyDayBetween(after,before) {
    var link =this.url + "/patient/" + this.user.id + "/getData/average/byDay/" + after + "/" + before
    return link
  }
  getUrlByUserIdbyWeekBetween(after,before) {
    var link =this.url + "/patient/" + this.user.id + "/getData/average/byWeek/" + after + "/" + before
    return link
  }
  getUrlByUserIdbyAllTimeBetween(before,after) {
    var link =this.url + "/patient/" + this.user.id + "/getData/average/allTime/" + before + "/" + after
    return link
  }
  getUrlLoginUser(){
    var link = this.url + "/login/loginUser"
    return link
  }
  getUrlLoginDoctor(){
    var link = this.url + "/login/loginDoctor"
    return link
  }


  getUrlAverageForDay(date) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/ForDay/" + date
    return link
    
  }
  getUrlAverageForWeek(date) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/ForWeek/" + date
    return link
  }
  getUrlAverageForMonth(date) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/ForMonth/" + date
    return link
  }
  getUrlAverageForYear(date) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/ForYear/" + date
    return link
  }
  getUrlAverageForAllTime(date) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/ForAllTime/" + date
    return link
  }
  getUrlAveragesByHour(startDate, endDate) {
    var link = this.url + "/patient/" + this.user.id + "/getData/average/byHour/"+ startDate + "/" + endDate
    return link
  }

  getUrlRecentBasal(){
    return this.url + '/patient/' + this.user.id + '/getData/recent/basal'
  }

  getUrlRecentBolus(){
    return this.url + '/patient/' + this.user.id + '/getData/recent/bolus'
  }

  getUrlRecentMeasurement(){
    return this.url + '/patient/' + this.user.id + '/getData/recent/measurement'
  }

  
  getUrlRecentMeals(){
    return this.url + '/patient/' + this.user.id + '/getData/recent/meals'
  }

    
  getUrlRecentExercise(){
    return this.url + '/patient/' + this.user.id + '/getData/recent/exercise'

  }

  getUrlCriticalLevels(date){
    console.log("crit level user: " ,this.user.id)
    return this.url + '/patient/' + this.user.id + '/getData/criticalLevels/' + date
  }


  
  getDatesFromChoice(choice_from_child){
    var  myCurrentDate= new Date()
    if (this.testfunctions){
       myCurrentDate.setMonth(0)
       myCurrentDate.setDate(28)
       console.log("testdate:", myCurrentDate)
    }


    var myPastDate=new Date(myCurrentDate);
      switch (choice_from_child) {
        case "Day": 
                  myPastDate.setDate(myPastDate.getDate() - 1)  //myPastDate is now 8 days in the past
                   break
        case "Week":
                 myPastDate.setDate(myPastDate.getDate() - 7)  //myPastDate is now 8 days in the past
                   break
        case "Month":
                  if (this.testfunctions) console.log("getMonth")   
                 myPastDate.setMonth(myPastDate.getMonth() - 1)  //myPastDate is now 8 days in the past
                   break
        case "Year":      
                  
                 if (this.testfunctions) console.log("getyear")  
                      
                 myPastDate.setFullYear(myPastDate.getFullYear() - 1)  //myPastDate is now 8 days in the past
                   break
        case "All time":
                 myPastDate.setDate(myPastDate.getDate() - 2000)  //myPastDate is now 8 days in the past
                   break
                   
          
      }
       
     
      
        myCurrentDate =moment(String(myCurrentDate)).format('YYYY-MM-DD hh:mm:ss')
        myPastDate =moment(String(myPastDate)).format('YYYY-MM-DD hh:mm:ss')
        
        console.log("Currentdate set to: ",myCurrentDate)
        console.log("Pastdate set to: ",myPastDate)
      return [myPastDate,myCurrentDate]
}

}
