import React from 'react';
import './App.css';
import { commentListItem, favoriteListMock, latestBoardListMock, top3BoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import CommentItem from 'components/CommentItem';
import commentListMock from 'mocks/comment-list.mock';
import FavoriteItem from 'components/FavoriteItem';

function App() {
  return (
  <>
  <div style={{ display: 'flex', flexDirection: 'column', columnGap: '30px', rowGap: '20px' }}>
    {favoriteListMock.map(favoriteListItem => <FavoriteItem favoriteListItem={favoriteListItem}/>)}
  </div>
  </>
  );
}

export default App;
