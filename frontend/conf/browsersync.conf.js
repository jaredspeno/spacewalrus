const conf = require('./gulp.conf');

var proxyMiddleware = require('http-proxy-middleware');

module.exports = function () {
  return {
    server: {
      baseDir: [
        conf.paths.tmp,
        conf.paths.src
      ],
      middleware: [
        proxyMiddleware('/api', {target: 'http://localhost:5000', changeOrigin: true})
      ]
    },
    open: false
  };
};
