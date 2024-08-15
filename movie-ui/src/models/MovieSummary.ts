export interface MovieSummary {
    adult: boolean;
    backdropPath: string;
    genreIds: number[];
    id: number;
    originCountry: string[];
    originalLanguage: string;
    originalTitle: string;
    overview: string;
    popularity: number;
    posterPath?: string;
    releaseDate: string;
    title: string;
    video: boolean;
    voteAverage: number;
    voteCount: number;
}