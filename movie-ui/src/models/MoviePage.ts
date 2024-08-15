export interface MoviePage<T> {
    page: number
    results: T[]
    totalPages: number
    totalResults: number
}