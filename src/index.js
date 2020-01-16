import Vue from 'vue';
import vuetify from './plugins/vuetify'

import router from './router';
import App from './App';
import axios from 'axios'


require('./vendor.js');
Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
	el: '#app',
	router,
	vuetify,
	render: (h) => h(App)
});
