import Vue from 'vue'
import App from './App.vue'
import router from './router'
// 引入插件
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//引入配置的axios文件
import request from '@/utils/request'
Vue.prototype.request=request
Vue.config.productionTip = false

Vue.use(ElementUI,{size:"mine"})
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
