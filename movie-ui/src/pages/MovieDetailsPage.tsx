import { useLoaderData } from "react-router-dom";
import { fetchMovieDetails } from '../services/movie-service';

export async function loader({params}: any) {
  const id = params.id;
  const data = await fetchMovieDetails(id);
  return data;
}

export default function MovieDetailsPage() {
  const data: any = useLoaderData();
  return (
    <div>{"Movie: " + JSON.stringify(data)}</div>
  );
}
