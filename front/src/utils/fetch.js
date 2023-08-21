// import { alert } from "@/Components/Common/Alert";
// import properties from "@/config/properties";
import { handleHttpError } from "@utils/error";

const fetchWrap = async ({ method, url, body }) => {
  const URL = `${import.meta.env.VITE_BASE_URL}/${url}`;
  try {
    const config = {
      method,
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    };
    const res =
      (method === "get" && (await fetch(URL))) ||
      (method === "post" && (await fetch(URL, config))) ||
      (method === "put" && (await fetch(URL, config))) ||
      (method === "delete" && (await fetch(URL, { method }))) ||
      {};

    if (!res.ok) handleHttpError(res.status);
    const data = await res.json();
    return data;
  } catch (error) {
    console.error;
  }
};

export const GET = (url) => fetchWrap({ method: "get", url });

export const POST = (url, body) => fetchWrap({ method: "post", url, body });

export const PATCH = (url, body) => fetchWrap({ method: "patch", url, body });

export const DELETE = (url) => fetchWrap({ method: "delete", url });
