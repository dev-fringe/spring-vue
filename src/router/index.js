import Vue from 'vue';
import Router from 'vue-router';

import * as routes from '../routes.js';
import Home from '../components/Home.vue';
import Hello from '../components/HelloWorld.vue';

Vue.use(Router);

export default new Router({
//   mode: 'history',
//   hash: false,	
	routes: [
		{
			path: routes.HOME_ROUTE,
			name: 'Root',
			component: Home
		},{
			path: routes.LIST_ROUTE,
			name: 'List',
			component: Hello
		},{
			path: '*',
			name: 'Wildcard',
			redirect: routes.HOME_ROUTE
		}
	]
});