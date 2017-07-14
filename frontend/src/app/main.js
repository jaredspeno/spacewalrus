export const main = {
  template: require('./main.html'),
  controller($log, $http) {
    const $ctrl = this;
    $ctrl.questions = [];
    $log.debug('HELLO!');
    $http.get('http://localhost:5000/questions').then(resp => {
      $ctrl.questions = resp.data;
    });
  }
};
