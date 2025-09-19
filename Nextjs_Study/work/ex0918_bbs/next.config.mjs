/** @type {import('next').NextConfig} */
const nextConfig = {
    //외부 링크 허용
        async rewrites() {
            return [
                {
                    source: '/api/:path*',
                    destination: 'http://localhost:8080/api/:path*',
                },
            ];
        },
};

export default nextConfig;
