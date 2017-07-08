export const main = {
  template: require('./main.html'),
  controller() {
    this.question = {
      questionId: 42,
      title: 'I am a question TITLE!',
      content: 'WOOOOOHOOO!',
      userId: 'SHAYKOG',
      tags: [
        'java', 'woot'
      ]
    };
  }
};
