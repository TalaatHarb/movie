export default function MovieCard({id, imagePosterLink, title}: Readonly<{id: number, imagePosterLink: string, title: string}>) {
    return (
        <div className="card movie-card" id={id + ""}>
            <img src={imagePosterLink} className="card-img-top" alt={title} />
            <div className="card-body">
                <p className="card-text">{title}</p>
            </div>
        </div>
    );
}
