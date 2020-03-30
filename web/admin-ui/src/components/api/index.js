let http = axios.create({
  baseURL: 'http://127.0.0.1:8080/api',
  withCredentials: true,
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
  }
});

http.interceptors.request.use(
  config => {
    // 判断本地的cookie中是否有token
    if (VueCookie.isKey('JSESSIONID')) {
      config.headers.Authorization = VueCookie.get('JSESSIONID')
    } else {
      // 跳转到登录页面(这里使用router，是因为路由文件引入到了此文件里)
      router.push('/login')
    }
    return config
  },
  error => {
    return Promise.reject(error)
  })

function apiAxios(method, url, params, response) {
  http({
    method: method,
    url: url,
    data: method === 'POST' || method === 'PUT' ? params : null,
    params: method === 'GET' || method === 'DELETE' ? params : null,
  }).then(function (res) {
    response(res);
  }).catch(function (err) {
    response(err);
  })
}

export default {
  get: function (url, params, response) {
    return apiAxios('GET', url, params, response)
  },
  post: function (url, params, response) {
    return apiAxios('POST', url, params, response)
  },
  put: function (url, params, response) {
    return apiAxios('PUT', url, params, response)
  },
  delete: function (url, params, response) {
    return apiAxios('DELETE', url, params, response)
  }
}
