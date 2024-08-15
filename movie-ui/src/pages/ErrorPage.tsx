import { Link, useRouteError } from "react-router-dom";

export default function ErrorPage() {
  const error: any = useRouteError();
  console.error(error);

  return (
    <>
      <header className='d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none'>
        <Link to='/' ><h1>Movies</h1></Link>
      </header>
      <section id="error-page">
        <h1>Oops!</h1>
        <p>Sorry, an unexpected error has occurred.</p>
        <p>
          <i>{error.statusText || error.message}</i>
        </p>
      </section>
    </>

  );
}