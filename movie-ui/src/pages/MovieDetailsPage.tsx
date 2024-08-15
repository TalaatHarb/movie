import { Link, useLoaderData } from "react-router-dom";
import { fetchMovieDetails } from '../services/movie-service';
import JsonTable from "../components/JsonTable";
import MovieCard from "../components/MovieCard";
import { Movie } from "../models/Movie";

export async function loader({ params }: any) {
  const id = params.id;
  const data = await fetchMovieDetails(id);
  return data;
}

export default function MovieDetailsPage() {
  const movie = useLoaderData() as Movie;
  return (
    <>
      <header className='d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none'>
        <Link to='/' ><h1>Movies</h1></Link>
      </header>
      <section style={{maxWidth: '400px'}}>
        <MovieCard id={movie.id} imagePosterLink={movie.posterPath} title={movie.title} />
      </section>
      <main className="mt-5">
        <JsonTable data={movie} />
      </main>
    </>

  );
}
