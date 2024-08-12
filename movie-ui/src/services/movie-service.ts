import { environment } from './environment';

const API_URL = environment.apiUrl;

const REQUEST_OPTIONS = {
    method: "GET",
};

export async function fetchPopularMoviesPage(page = 1) {
    const jsonData = await fetch(`${API_URL}/movie/popular?page=${page}`, REQUEST_OPTIONS);
    const data = await jsonData.json();

    return data;
}

export async function fetchSearchPage(searchTerm: string, page = 1) {
    const jsonData = await fetch(`${API_URL}/search/movie?searchTerm=${searchTerm}&page=${page}`, REQUEST_OPTIONS)
    const data = await jsonData.json();

    return data;
}

export async function fetchMovieDetails(id: number) {
    const jsonData = await fetch(`${API_URL}/movie/${id}`, REQUEST_OPTIONS)
    const data = await jsonData.json();

    return data;
}