export default {
  template: require('./main.html'),
  controller($http) {
    const $ctrl = this;
    $http.get('/api/questions').then(resp => {
      $ctrl.questions = resp.data;
    });
  }
};
