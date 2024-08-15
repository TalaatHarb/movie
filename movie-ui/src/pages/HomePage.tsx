import { Link, useLoaderData, useSearchParams } from 'react-router-dom';
import { fetchPopularMoviesPage, fetchSearchPage } from '../services/movie-service';
import MovieCard from '../components/MovieCard';
import { MoviePage } from '../models/MoviePage';
import { MovieSummary } from '../models/MovieSummary';
import Pagination from '../components/Pagination';

export async function loader({ request }: { request: Request }) {
  const searchParams = new URL(request.url).searchParams;
  const page = (searchParams.has("page") ? searchParams.get("page") : 1) as number;
  const searchTerm = searchParams.has("searchTerm") ? searchParams.get("searchTerm") : undefined;

  console.log(page);
  console.log(searchTerm);

  const data = searchTerm ? (await fetchSearchPage(searchTerm, page)) : (await fetchPopularMoviesPage(page));
  return data;
}

export default function HomePage() {
  const { page, results, totalPages } = useLoaderData() as MoviePage<MovieSummary>;
  const [searchParams, _] = useSearchParams();
  const searchTerm: string | undefined | null = searchParams.has("searchTerm") ? searchParams.get("searchTerm") : undefined;
  return (
    <>
      <header>
        <form className="d-flex">
          <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" name='searchTerm' />
          <button className="btn btn-primary" type="submit">Search</button>
        </form>
      </header>
      <section className='pt-5'><Pagination page={page} totalPages={totalPages} searchTerm={searchTerm} /></section>
      <main>
        <div className="album py-5">
          <div className="container">

            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-4">
              {
                results.map(movie => {
                  return (
                    <Link className="col" key={movie.id} to={`/movies/${movie.id}`}>
                      <MovieCard id={movie.id} title={movie.title} imagePosterLink={movie.posterPath ? movie.posterPath : 'https://upload.wikimedia.org/wikipedia/commons/4/4b/Empty_frame.jpg'} />
                    </Link>
                  );
                })
              }
            </div>
          </div>
        </div>
      </main>
      <footer>
        <Pagination page={page} totalPages={totalPages} searchTerm={searchTerm} />
      </footer>
    </>
  );
}
