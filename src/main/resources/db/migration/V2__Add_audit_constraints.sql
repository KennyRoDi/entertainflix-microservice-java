-- Add constraint only if it doesn't exist
DO $$
BEGIN
    ALTER TABLE audit_logs
    ADD CONSTRAINT ck_transaction_type CHECK (
        transaction_type IN (
            'ACCEPTED_REQUEST',
            'DENIED_REQUEST',
            'NEW_PROFILE',
            'PROFILE_UPDATE',
            'REQUEST_CREATED',
            'SYSTEM_EVENT'
        )
    );
EXCEPTION WHEN duplicate_object THEN
    NULL;
END$$;

-- Create composite index if it doesn't exist
CREATE INDEX IF NOT EXISTS idx_user_transaction ON audit_logs(user_id, transaction_type);