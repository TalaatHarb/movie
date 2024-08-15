const IMAGE_POSTER_URL = 'https://images.tmdb.org/t/p/w400';

export default function MovieCard({id, imagePosterLink, title}: Readonly<{id: number, imagePosterLink?: string, title: string}>) {
    const posterURL = imagePosterLink ?? 'https://upload.wikimedia.org/wikipedia/commons/4/4b/Empty_frame.jpg' ;
    return (
        <div className="card movie-card" id={id + ""}>
            <img src={posterURL.startsWith('http') ? posterURL : (IMAGE_POSTER_URL + posterURL)} className="card-img-top" alt={title} />
            <div className="card-body">
                <p className="card-text">{title}</p>
            </div>
        </div>
    );
}
