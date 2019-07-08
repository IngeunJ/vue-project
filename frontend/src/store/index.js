import Vue from "vue";
import Vuex from "vuex";


Vue.use(Vuex);

const store = new Vuex.Store({
  state:{
    userInfo:{
        loginflag:false,
        userId:''
	},
	boardInfo:{
		bon:'',
		title:'',
		content:''
	}
  },
  getters:{

  },
  actions:{

  },
  mutations:{

  }
});

export default store;