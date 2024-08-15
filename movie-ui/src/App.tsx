import './App.css'
import HomePage, { loader as moviePageLoader} from './pages/HomePage.tsx';
import ErrorPage from './pages/ErrorPage.tsx';
import MovieDetailsPage, {loader as movieLoader} from './pages/MovieDetailsPage.tsx';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

const router = createBrowserRouter([
  {
    path: "/",
    element: <HomePage />,
    errorElement: <ErrorPage />,
    loader: moviePageLoader,
  },
  {
    path: "/movies/:id",
    element: <MovieDetailsPage />,
    loader: movieLoader,
  },
]);

function App() {

  return (
    <RouterProvider router={router} />
  )
}

export default App
