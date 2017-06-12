import { IguerendiainPage } from './app.po';

describe('iguerendiain App', () => {
  let page: IguerendiainPage;

  beforeEach(() => {
    page = new IguerendiainPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
