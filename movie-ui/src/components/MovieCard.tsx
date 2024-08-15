const IMAGE_POSTER_URL = 'https://images.tmdb.org/t/p/w400';

export default function MovieCard({id, imagePosterLink, title}: Readonly<{id: number, imagePosterLink: string, title: string}>) {
    return (
        <div className="card movie-card" id={id + ""}>
            <img src={imagePosterLink.startsWith('http') ? imagePosterLink : (IMAGE_POSTER_URL + imagePosterLink)} className="card-img-top" alt={title} />
            <div className="card-body">
                <p className="card-text">{title}</p>
            </div>
        </div>
    );
}
