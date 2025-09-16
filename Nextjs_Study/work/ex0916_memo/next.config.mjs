/** @type {import('next').NextConfig} */
const nextConfig = {
    async rewrites() {
        return [
            {
                source: '/memo/:path*',
                destination: 'http://localhost:8080/memo/:path*',
            },
        ];
    },
};

export default nextConfig;
