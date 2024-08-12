import { useLoaderData } from 'react-router-dom';
import { fetchPopularMoviesPage } from '../services/movie-service';

export async function loader() {
  const data = await fetchPopularMoviesPage();
  return data;
}

export default function HomePage() {
  const data: any = useLoaderData();
  return (
    <div>{'Popular movies: ' + JSON.stringify(data)} </div>
  );
}
