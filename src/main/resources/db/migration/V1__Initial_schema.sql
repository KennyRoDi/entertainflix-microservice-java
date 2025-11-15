CREATE TABLE IF NOT EXISTS audit_logs (
    transaction_id UUID PRIMARY KEY,
    request_id VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    actor_type VARCHAR(50),
    transaction_type VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    metadata TEXT,
    previous_state TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_request_id ON audit_logs(request_id);
CREATE INDEX IF NOT EXISTS idx_user_id ON audit_logs(user_id);
CREATE INDEX IF NOT EXISTS idx_timestamp ON audit_logs(timestamp);
CREATE INDEX IF NOT EXISTS idx_transaction_type ON audit_logs(transaction_type);
