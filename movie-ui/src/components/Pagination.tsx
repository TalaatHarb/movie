import { Link } from "react-router-dom";

const Pagination = ({ page, totalPages, searchTerm }: { page: number, totalPages: number, searchTerm: string | undefined | null}) => {
    const nextPageURL = searchTerm ? `?page=${page + 1}&searchTerm=${searchTerm}`: `?page=${page + 1}`;
    const previousPageURL = searchTerm ? `?page=${page - 1}&searchTerm=${searchTerm}`: `?page=${page - 1}`;
    return (
        <nav aria-label="Page navigation">
            <ul className="pagination justify-content-center">
                <li className={`page-item ${page <= 1 ? 'disabled' : ''}`}>
                    <Link className="page-link" to={previousPageURL} aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </Link>
                </li>

                <li className="page-item active">
                    <span className="page-link">
                        {`${page} / ${totalPages}`}
                    </span>
                </li>

                <li className={`page-item ${page >= totalPages ? 'disabled' : ''}`}>
                    <Link className="page-link" to={nextPageURL} aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </Link>
                </li>
            </ul>
        </nav>
    );
};

export default Pagination;