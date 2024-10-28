import React from 'react';
import './App.css';
import { commentListItem, favoriteListMock, latestBoardListMock, top3BoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import CommentItem from 'components/CommentItem';
import commentListMock from 'mocks/comment-list.mock';
import FavoriteItem from 'components/FavoriteItem';
import InputBox from 'components/InputBox';

function App() {
  return (
  <>
    <InputBox />
  </>
  );
}

export default App;
