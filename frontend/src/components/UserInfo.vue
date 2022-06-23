<template>
  <div>
    <div id="titles">
      <div class="element"><a> User ID </a></div>
      <div class="element"><a> Doctor Name </a></div>
      <div class="element"><a> Full Name </a></div>
      <div class="element"><a> email-address </a></div>
      <div class="element"><a> password </a></div>
    </div>
    <div id="props">
      <div class="element" style="font-weight: bold">
        <a> {{ this.$backend.user.id }} </a>
      </div>
      <div class="element" style="font-weight: bold">
        <a> {{ this.$backend.doctor.fullName }} </a>
      </div>
      <div class="element">
        <a> {{ this.$backend.user.fullName }} </a>
      </div>
      <div class="element">
        <a> {{ this.$backend.user.email }} </a>
      </div>
      <div class="element"><a> ****** </a></div>
    </div>
    <div id="alter">
      <div class="invisibel">invisibel</div>
      <div class="invisibel">invisibel</div>
      <div
        class="element"
        v-on:click="
          (this.changeName = !this.changeName),
            (this.changePassword = false),
            (this.changeEmail = false),
            (this.changeDoctor = false)
        "
      >
        <img class="edit" src="../assets/editing.png" alt="Fejl" />
      </div>
      <div
        class="element"
        v-on:click="
          (this.changeEmail = !this.changeEmail),
            (this.changePassword = false),
            (this.changeName = false),
            (this.changeDoctor = false)
        "
      >
        <img class="edit" src="../assets/editing.png" alt="Fejl" />
      </div>
      <div
        class="element"
        v-on:click="
          (this.changePassword = !this.changePassword),
            (this.changeEmail = false),
            (this.changeName = false),
            (this.changeDoctor = false)
        "
      >
        <img class="edit" src="../assets/editing.png" alt="Fejl" />
      </div>
    </div>
    <div id="inputs">
      <div class="invisibel">d <input type="text" /></div>
      <div class="invisibel">d <input type="text" /></div>
      <div :class="[changeName ? 'visibel' : 'invisibel']">
        <input class="text" type="text" id="changedname" placeholder="new name" />
        <input class="button" type="submit" @click="change()" value="Change" />
      </div>
      <div :class="[changeEmail ? 'visibel' : 'invisibel']">
        <input class="text" type="text" id="changedemail" placeholder="new email" />
        <input class="button" type="submit" @click="change()" value="Change" />
      </div>
      <div :class="[changePassword ? 'visibel' : 'invisibel']">
        <input class="text" type="text" id="oldpassword" placeholder="old password" />
        <input class="text" type="text" id="newpassword" placeholder="new password" />
        <input class="button" type="submit" @click="change()" value="Change" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserInfo",
  props: [],
  data() {
    return {
      changeName: false,
      changeEmail: false,
      changePassword: false,
    };
  },
  methods: {
    change() {
      var correct = true;
      var newpassword = this.$backend.user.password;
      var newname =this.$backend.user.fullName 
      var newemail=this.$backend.user.email

      console.log("kørt");
      if (this.changeName) {
        correct =
          correct &&  this.$regex.checkName(document.getElementById("changedname").value);
          newname= document.getElementById("changedname").value
        this.changeName = false;
      }
      if (this.changeEmail) {
        correct = correct && this.$regex.checkEmail(document.getElementById("changedemail").value);
        this.changeEmail = false;
        newemail= document.getElementById("changedemail").value
      }
      if (this.changePassword) {
        correct =  correct && this.$regex.checkpassword(document.getElementById("oldpassword").value,    this.$backend.user.password      );
        newpassword = document.getElementById("newpassword").value;
        this.changePassword = false;
      }

      

    
      if (correct) {

        this.$backend.user.email = newemail
        this.$backend.user.fullName = newname

        var link = this.$backend.getUrlUpdateUser() + "/" + newpassword ;
    
        console.log("user before:", this.$backend.user)
        console.log("url", link, ".correct:" , correct);
       
        this.axios.get(link).then((res) => {
          console.log("updated", res);
          this.$backend.user = res.data;
        });
      }
    },
  },
  created() {
    console.log("propDoctor", this.doctor);
  },
};
</script>

<style>
div#titles {
  float: left;
  width: 15vw;
}
div#props {
  float: left;
  width: 15w;
}
div#alter {
  padding-left: 5vw;
  float: left;
  width: 15vw;
}

img.edit {
  height: 60%;
  width: auto;
}
input.text {
  font-size: 1.8vw;
  height: 2vw;
  width: 12vw;
}
input.button {
  font-size: 1.7vw;
  height: 2.8vw;
}

.element {
  font-size: 1.8vw;
  height: 4vw;
}

.visibel {
  height: 4vw;
}
.invisibel {
  height: 4vw;
  visibility: hidden;
}
</style>
