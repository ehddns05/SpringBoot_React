(function(t){function e(e){for(var r,o,u=e[0],c=e[1],s=e[2],l=0,p=[];l<u.length;l++)o=u[l],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&p.push(a[o][0]),a[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(t[r]=c[r]);v&&v(e);while(p.length)p.shift()();return i.push.apply(i,s||[]),n()}function n(){for(var t,e=0;e<i.length;e++){for(var n=i[e],r=!0,o=1;o<n.length;o++){var u=n[o];0!==a[u]&&(r=!1)}r&&(i.splice(e--,1),t=c(c.s=n[0]))}return t}var r={},o={app:0},a={app:0},i=[];function u(t){return c.p+"js/"+({about:"about"}[t]||t)+"."+{about:"e4f39f1d"}[t]+".js"}function c(e){if(r[e])return r[e].exports;var n=r[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(t){var e=[],n={about:1};o[t]?e.push(o[t]):0!==o[t]&&n[t]&&e.push(o[t]=new Promise((function(e,n){for(var r="css/"+({about:"about"}[t]||t)+"."+{about:"cda248ee"}[t]+".css",a=c.p+r,i=document.getElementsByTagName("link"),u=0;u<i.length;u++){var s=i[u],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===r||l===a))return e()}var p=document.getElementsByTagName("style");for(u=0;u<p.length;u++){s=p[u],l=s.getAttribute("data-href");if(l===r||l===a)return e()}var v=document.createElement("link");v.rel="stylesheet",v.type="text/css",v.onload=e,v.onerror=function(e){var r=e&&e.target&&e.target.src||a,i=new Error("Loading CSS chunk "+t+" failed.\n("+r+")");i.code="CSS_CHUNK_LOAD_FAILED",i.request=r,delete o[t],v.parentNode.removeChild(v),n(i)},v.href=a;var f=document.getElementsByTagName("head")[0];f.appendChild(v)})).then((function(){o[t]=0})));var r=a[t];if(0!==r)if(r)e.push(r[2]);else{var i=new Promise((function(e,n){r=a[t]=[e,n]}));e.push(r[2]=i);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,c.nc&&l.setAttribute("nonce",c.nc),l.src=u(t);var p=new Error;s=function(e){l.onerror=l.onload=null,clearTimeout(v);var n=a[t];if(0!==n){if(n){var r=e&&("load"===e.type?"missing":e.type),o=e&&e.target&&e.target.src;p.message="Loading chunk "+t+" failed.\n("+r+": "+o+")",p.name="ChunkLoadError",p.type=r,p.request=o,n[1](p)}a[t]=void 0}};var v=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(e)},c.m=t,c.c=r,c.d=function(t,e,n){c.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},c.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},c.t=function(t,e){if(1&e&&(t=c(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)c.d(n,r,function(e){return t[e]}.bind(null,r));return n},c.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return c.d(e,"a",e),e},c.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},c.p="/",c.oe=function(t){throw console.error(t),t};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=e,s=s.slice();for(var p=0;p<s.length;p++)e(s[p]);var v=l;i.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("cd49")},"0b05":function(t,e,n){},1550:function(t,e,n){"use strict";var r=n("0b05"),o=n.n(r);o.a},"5c0b":function(t,e,n){"use strict";var r=n("7694"),o=n.n(r);o.a},7694:function(t,e,n){},cd49:function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-app",{attrs:{id:"inspire"}},[n("v-navigation-drawer",{attrs:{app:""},model:{value:t.drawer,callback:function(e){t.drawer=e},expression:"drawer"}},[n("v-list",{attrs:{dense:""}},[n("v-list-item",{attrs:{link:""}},[n("v-list-item-action",[n("v-icon",[t._v("mdi-home")])],1),n("v-list-item-content",{on:{click:function(e){return t.$router.push({name:"Home"})}}},[n("v-list-item-title",[t._v("Home")])],1)],1),n("v-list-item",{attrs:{link:""}},[n("v-list-item-action",[n("v-icon",[t._v("mdi-contact-mail")])],1),n("v-list-item-content",{on:{click:function(e){return t.$router.push({name:"Board"})}}},[n("v-list-item-title",[t._v("board")])],1)],1)],1)],1),n("v-app-bar",{attrs:{app:"",color:"indigo",dark:""}},[n("v-app-bar-nav-icon",{on:{click:function(e){e.stopPropagation(),t.drawer=!t.drawer}}}),n("v-toolbar-title",[t._v("Application")]),n("v-spacer"),t.authorization?n("div",{},[n("v-btn",{attrs:{text:""},on:{click:function(e){return t.logout()}}},[t._v(" Logout ")])],1):n("div",{},[n("v-btn",{attrs:{text:""},on:{click:function(e){return t.$router.push({name:"SignUp"})}}},[t._v(" sign-up ")]),n("v-btn",{attrs:{text:""},on:{click:function(e){return t.$router.push({name:"login"})}}},[t._v(" sign-in ")])],1)],1),n("v-content",[n("router-view")],1),n("v-footer",{attrs:{color:"indigo",app:""}},[n("span",{staticClass:"white--text"},[t._v("© 2019")])])],1)},a=[],i=n("5530"),u=n("d4ec"),c=n("262e"),s=n("2caf"),l=n("9ab4"),p=n("60a3"),v=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"hello"},[n("h1",[t._v(t._s(t.msg))]),t._m(0),n("h3",[t._v("Installed CLI Plugins")]),t._m(1),n("h3",[t._v("Essential Links")]),t._m(2),n("h3",[t._v("Ecosystem")]),t._m(3)])},f=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("p",[t._v(" For a guide and recipes on how to configure / customize this project,"),n("br"),t._v(" check out the "),n("a",{attrs:{href:"https://cli.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("vue-cli documentation")]),t._v(". ")])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("ul",[n("li",[n("a",{attrs:{href:"https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-typescript",target:"_blank",rel:"noopener"}},[t._v("typescript")])])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("ul",[n("li",[n("a",{attrs:{href:"https://vuejs.org",target:"_blank",rel:"noopener"}},[t._v("Core Docs")])]),n("li",[n("a",{attrs:{href:"https://forum.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("Forum")])]),n("li",[n("a",{attrs:{href:"https://chat.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("Community Chat")])]),n("li",[n("a",{attrs:{href:"https://twitter.com/vuejs",target:"_blank",rel:"noopener"}},[t._v("Twitter")])]),n("li",[n("a",{attrs:{href:"https://news.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("News")])])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("ul",[n("li",[n("a",{attrs:{href:"https://router.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("vue-router")])]),n("li",[n("a",{attrs:{href:"https://vuex.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("vuex")])]),n("li",[n("a",{attrs:{href:"https://github.com/vuejs/vue-devtools#vue-devtools",target:"_blank",rel:"noopener"}},[t._v("vue-devtools")])]),n("li",[n("a",{attrs:{href:"https://vue-loader.vuejs.org",target:"_blank",rel:"noopener"}},[t._v("vue-loader")])]),n("li",[n("a",{attrs:{href:"https://github.com/vuejs/awesome-vue",target:"_blank",rel:"noopener"}},[t._v("awesome-vue")])])])}],h=function(){var t=function(t){Object(c["a"])(n,t);var e=Object(s["a"])(n);function n(){return Object(u["a"])(this,n),e.apply(this,arguments)}return n}(p["c"]);return Object(l["a"])([Object(p["b"])()],t.prototype,"msg",void 0),t=Object(l["a"])([p["a"]],t),t}(),d=h,m=d,b=(n("1550"),n("2877")),g=Object(b["a"])(m,v,f,!1,null,"7d3f3026",null),_=g.exports,j=n("2f62"),w=n("bc3a"),y=n.n(w),k=function(){var t=function(t){Object(c["a"])(n,t);var e=Object(s["a"])(n);function n(){return Object(u["a"])(this,n),e.apply(this,arguments)}return n}(p["c"]);return t=Object(l["a"])([Object(p["a"])({components:{HelloWorld:_},methods:{logout:function(){var t=this;y.a.get("/logout").then((function(e){console.log(e.status),t.$store.commit("logout"),t.$router.go(0)})).catch((function(t){console.log(t)}))}},computed:Object(i["a"])({},Object(j["c"])(["authorization"]))})],t),t}(),O=k,x=O,E=(n("5c0b"),n("6544")),C=n.n(E),S=n("7496"),$=n("40dc"),V=n("5bc1"),L=n("8336"),P=n("a75b"),A=n("553a"),z=n("132d"),I=n("8860"),T=n("da13"),B=n("1800"),H=n("5d23"),N=n("f774"),D=n("2fa4"),F=n("2a7f"),M=Object(b["a"])(x,o,a,!1,null,null,null),U=M.exports;C()(M,{VApp:S["a"],VAppBar:$["a"],VAppBarNavIcon:V["a"],VBtn:L["a"],VContent:P["a"],VFooter:A["a"],VIcon:z["a"],VList:I["a"],VListItem:T["a"],VListItemAction:B["a"],VListItemContent:H["a"],VListItemTitle:H["b"],VNavigationDrawer:N["a"],VSpacer:D["a"],VToolbarTitle:F["a"]});n("d3b7");var q=n("8c4f"),J=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"home"},[r("img",{attrs:{alt:"Vue logo",src:n("cf05")}}),r("p",[t._v("1."+t._s(this.$store.state.authorization))]),r("p",[t._v("2."+t._s(t.$store.state.authorization))])])},K=[],W={name:"Home",components:{}},G=W,Q=Object(b["a"])(G,J,K,!1,null,null,null),R=Q.exports;r["a"].use(q["a"]);var X=[{path:"/",name:"Home",component:R},{path:"/signUp",name:"SignUp",component:function(){return n.e("about").then(n.bind(null,"5c9c"))}},{path:"/login",name:"login",component:function(){return n.e("about").then(n.bind(null,"54e2"))}},{path:"/main",name:"main",component:function(){return n.e("about").then(n.bind(null,"cd56"))}},{path:"/board",name:"Board",component:function(){return n.e("about").then(n.bind(null,"4a09"))}},{path:"/user/board/writing_Page",name:"Board_writing_Page",component:function(){return n.e("about").then(n.bind(null,"2c8d"))}},{path:"/BoardDetail:boardnum",name:"BoardDetail",component:function(){return n.e("about").then(n.bind(null,"69ce"))}}],Y=new q["a"]({mode:"history",base:"/",routes:X}),Z=Y;r["a"].use(j["a"]);var tt=window.sessionStorage,et=new j["a"].Store({state:{authorization:!1,isLogin:!1,board:[{boardnum:null,board_title:null,writer:null,hits:null,date:null}]},mutations:{loginSuccess:function(t){t.authorization=!0},setHeader:function(){y.a.defaults.headers.common["Authorization"]=tt.getItem("authorization")},logout:function(){tt.removeItem("authorization")}},actions:{login_Status:function(t){var e=t.commit,n=tt.getItem("authorization");null!=n&&(e("setHeader"),this.state.authorization=!0)}},modules:{},getters:{get_board:function(t){y.a.post("/board/findAll").then((function(e){console.log(e),t.board=e.data,console.log(t.board)})).catch((function(t){console.log(t)}))}}}),nt=n("f309");r["a"].use(nt["a"]);var rt=new nt["a"]({});r["a"].config.productionTip=!1,new r["a"]({router:Z,store:et,vuetify:rt,beforeCreate:function(){this.$store.dispatch("login_Status")},render:function(t){return t(U)}}).$mount("#app")},cf05:function(t,e,n){t.exports=n.p+"img/logo.82b9c7a5.png"}});
//# sourceMappingURL=app.9198f30b.js.map