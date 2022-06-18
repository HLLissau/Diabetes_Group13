
export default class Regexchecks {
    
  constructor() {
    
  }

checkEmail(email) {
      
    var filter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email)) {
      alert('Please provide a valid email address');
      email.focus;
      return false;
    }
}
  checkName(name) {
    var filter = /^([a-zA-Z0-9_.-])+((\s)+[a-zA-Z0-9-]+)+$/
    if (!filter.test(name)) {
      alert('Please provide firstname and surname');
      name.focus;
      return false;
    }
  }
 checkpassword(pass1,pass2) {
    if (pass1.value !=pass2.value) {
      alert('passwords do not match');
      pass2.focus;
      return false;
    }
}

}